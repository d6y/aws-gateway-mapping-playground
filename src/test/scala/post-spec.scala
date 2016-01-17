import org.scalatest._

class PostSpec extends FreeSpec {

  implicit class StringOps(s: String) {
    def ignoreWhitespace: String = s.replaceAll("\\s+","")
  }

  "post.vm" - {

    "should decode into form encoded post to JSON" in {

      val input =
        "token=tokenvalue" +
        "&team_id=T123AB4CD" +
        "&team_domain=underscoreio" +
        "&channel_id=G1ABCD2EF" +
        "&channel_name=privategroup" +
        "&user_id=U012U3ABC" +
        "&user_name=richard" +
        "&command=%2Ftime" +
        "&text=Sydney" +
        "&response_url=https%3A%2F%2Fhooks.slack.com%2Fcommands%2FT123AB4CD%2F123%2F0foo"

      val expect = s"""
        | {
        |  "token" : "tokenvalue",
        |  "team_id" : "T123AB4CD",
        |  "team_domain" : "underscoreio",
        |  "channel_id" : "G1ABCD2EF",
        |  "channel_name" : "privategroup",
        |  "user_id" : "U012U3ABC",
        |  "user_name" : "richard",
        |  "command" : "/time",
        |  "text" : "Sydney",
        |  "response_url" : "https://hooks.slack.com/commands/T123AB4CD/123/0foo"
        |}
       """.stripMargin.trim

      assertResult(expect.ignoreWhitespace) {
        Runner.run(
          "src/test/resources/post.vm",
          Context(),
          Input(data=input)
        ).ignoreWhitespace
      }
    }
  }

}