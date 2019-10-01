package org.apache.netbeans.modules.scala.sbt.project

/**
 *
 * also @see org.apache.netbeans.api.java.project.JavaProjectConstants
 *
 * @author Caoyuan Deng
 */
object ProjectConstants {

  /**
   * Hint for <code>SourceGroupModifier</code> to create a <code>SourceGroup</code>
   * for main project codebase.
   * @see org.apache.netbeans.api.project.SourceGroupModifier
   * @since org.apache.netbeans.modules.java.project/1 1.24
   */
  val SOURCES_HINT_MAIN = "main" //NOI18N

  /**
   * Hint for <code>SourceGroupModifier</code> to create a <code>SourceGroup</code>
   * for project's tests.
   * @see org.apache.netbeans.api.project.SourceGroupModifier
   * @since org.apache.netbeans.modules.java.project/1 1.24
   */
  val SOURCES_HINT_TEST = "test" //NOI18N

  /**
   * Standard artifact type representing a JAR file, presumably
   * used as a Java library of some kind.
   * @see org.apache.netbeans.api.project.ant.AntArtifact
   */
  val ARTIFACT_TYPE_JAR = "jar" // NOI18N

  /**
   * Standard artifact type representing a folder containing classes, presumably
   * used as a Java library of some kind.
   * @see org.apache.netbeans.api.project.ant.AntArtifact
   * @since org.apache.netbeans.modules.java.project/1 1.4
   */
  val ARTIFACT_TYPE_FOLDER = "folder" //NOI18N

  /**
   * Standard command for running Javadoc on a project.
   * @see org.apache.netbeans.spi.project.ActionProvider
   */
  val COMMAND_JAVADOC = "javadoc" // NOI18N

  /**
   * Standard command for reloading a class in a foreign VM and continuing debugging.
   * @see org.apache.netbeans.spi.project.ActionProvider
   */
  val COMMAND_DEBUG_FIX = "debug.fix" // NOI18N

  val PROJECT_FOLDER_NAME = "project"

  val NAME_SCALASOURCE = "81ScalaSourceRoot"
  val NAME_SCALATESTSOURCE = "82ScalaTestSourceRoot"
  val NAME_JAVASOURCE = "83JavaSourceRoot"
  val NAME_JAVATESTSOURCE = "84JavaTestSourceRoot"
  val NAME_RESOURCESSOURCE = "85ResourcesSourceRoot"
  val NAME_RESOURCESTESTSOURCE = "86ResourcesTestSourceRoot"
  val NAME_MANAGEDSOURCE = "93ManagedSourceRoot"
  val NAME_MANAGEDTESTSOURCE = "94ManagedTestSourceRoot"
  val NAME_DEP_PROJECTS = "95DepProjects"
  val NAME_DEP_LIBRARIES = "96DepLibraries"
  val NAME_OTHERSOURCE = "98OtherSourceRoot"

}

