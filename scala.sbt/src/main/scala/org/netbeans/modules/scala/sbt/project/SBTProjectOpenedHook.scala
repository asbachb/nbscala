package org.apache.netbeans.modules.scala.sbt.project

import org.apache.netbeans.api.java.classpath.ClassPath
import org.apache.netbeans.api.java.classpath.GlobalPathRegistry
import org.apache.netbeans.api.project.Project
import org.apache.netbeans.modules.scala.sbt.classpath.SBTClassPathProvider
import org.apache.netbeans.spi.project.ui.ProjectOpenedHook

/**
 *
 * @author Caoyuan Deng
 */
class SBTProjectOpenedHook(project: Project) extends ProjectOpenedHook {
  private var classpaths: Array[ClassPath] = _

  protected def projectOpened() {
    val cpProvider = project.getLookup.lookup(classOf[SBTClassPathProvider])
    classpaths = Array(
      cpProvider.getClassPath(ClassPath.COMPILE, isTest = false),
      cpProvider.getClassPath(ClassPath.COMPILE, isTest = true))

    GlobalPathRegistry.getDefault.register(ClassPath.COMPILE, classpaths)
  }

  protected def projectClosed() {
    GlobalPathRegistry.getDefault.unregister(ClassPath.COMPILE, classpaths)
    SBTResolver.dirWatcher.removeChangeListener(project.getLookup.lookup(classOf[SBTResolver]))
  }
}
