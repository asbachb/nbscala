package org.apache.netbeans.modules.scala.sbt.nodes

import javax.swing.event.ChangeListener
import org.apache.netbeans.api.project.Project
import org.apache.netbeans.api.project.ProjectUtils
import org.apache.netbeans.api.project.SourceGroup
import org.apache.netbeans.modules.scala.core.ProjectResources
import org.apache.netbeans.modules.scala.sbt.project.SBTResolver
import org.apache.netbeans.spi.java.project.support.ui.PackageView
import org.apache.netbeans.spi.project.ui.support.NodeFactory
import org.apache.netbeans.spi.project.ui.support.NodeList
import org.openide.nodes.Node
import org.openide.util.ChangeSupport

class SourcesNodeFactory extends NodeFactory {
  def createNodes(project: Project): NodeList[_] = new SourcesNodeFactory.SourcesNodeList(project)
}

object SourcesNodeFactory {
  private class SourcesNodeList(project: Project) extends NodeList[SourceGroup] {
    private val cs = new ChangeSupport(this)
    private lazy val sbtResolver = project.getLookup.lookup(classOf[SBTResolver])

    override def keys: java.util.List[SourceGroup] = {
      val theKeys = new java.util.ArrayList[SourceGroup]()

      val sources = ProjectUtils.getSources(project)
      val javaSgs = sources.getSourceGroups(ProjectResources.SOURCES_TYPE_JAVA)
      javaSgs foreach theKeys.add
      val scalaSgs = sources.getSourceGroups(ProjectResources.SOURCES_TYPE_SCALA)
      scalaSgs foreach theKeys.add
      val resourcesSgs = sources.getSourceGroups(ProjectResources.SOURCES_TYPE_RESOURCES)
      resourcesSgs foreach theKeys.add
      val managedSgs = sources.getSourceGroups(ProjectResources.SOURCES_TYPE_MANAGED)
      managedSgs foreach theKeys.add

      java.util.Collections.sort(theKeys, new java.util.Comparator[SourceGroup]() {
        def compare(o1: SourceGroup, o2: SourceGroup) = o1.getName.compareTo(o2.getName)
      })

      theKeys
    }

    override def node(key: SourceGroup): Node = PackageView.createPackageView(key)

    def addNotify() {

    }

    def removeNotify() {

    }

    override def addChangeListener(l: ChangeListener) {
      cs.addChangeListener(l)
    }

    override def removeChangeListener(l: ChangeListener) {
      cs.removeChangeListener(l)
    }
  }
}