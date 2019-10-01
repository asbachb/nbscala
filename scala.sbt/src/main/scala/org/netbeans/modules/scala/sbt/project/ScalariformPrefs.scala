package org.apache.netbeans.modules.scala.sbt.project

import org.apache.netbeans.api.project.Project
import org.apache.netbeans.modules.scala.editor.spi.ScalariformPrefsProvider

class ScalariformPrefs(project: Project) extends ScalariformPrefsProvider {
  private lazy val sbtResolver = project.getLookup.lookup(classOf[SBTResolver])

  def formatPreferences = sbtResolver.projectContext.scalariformPrefs
}
