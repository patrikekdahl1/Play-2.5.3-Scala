
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/patrikekdahlspeddodator/IdeaProjects/PlayScala/conf/routes
// @DATE:Fri May 20 12:40:03 CEST 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
