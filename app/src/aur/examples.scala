package aur

object examples {

  val searchForBloop =
    """
      |{
      |  "version" : 5,
      |  "type" : "search",
      |  "resultcount" : 1,
      |  "results" : [
      |    {
      |      "ID" : 619762,
      |      "Name" : "bloop",
      |      "PackageBaseID" : 133763,
      |      "PackageBase" : "bloop",
      |      "Version" : "1.3.2-1",
      |      "Description" : "Bloop gives you fast edit/compile/test workflows for Scala.",
      |      "URL" : "https://scalacenter.github.io/bloop/",
      |      "NumVotes" : 6,
      |      "Popularity" : 1.661279,
      |      "OutOfDate" : null,
      |      "Maintainer" : "TheElectronWill",
      |      "FirstSubmitted" : 1529949696,
      |      "LastModified" : 1560037480,
      |      "URLPath" : "/cgit/aur.git/snapshot/bloop.tar.gz"
      |    }
      |  ]
      |}
    """.stripMargin

  val searchForDependsScala =
    """
      |{
      |  "version" : 5,
      |  "type" : "search",
      |  "resultcount" : 9,
      |  "results" : [
      |    {
      |      "ID" : 184081,
      |      "Name" : "mkscaladocset-hg",
      |      "PackageBaseID" : 92977,
      |      "PackageBase" : "mkscaladocset-hg",
      |      "Version" : "17.4db14a8f5bb0-1",
      |      "Description" : "mkScalaDocset is a script and accompanying Scala code to build documentation sets for the Dash documentation browser from documentation that has been produced by ScalaDoc.",
      |      "URL" : "https://bitbucket.org/inkytonik/mkscaladocset",
      |      "NumVotes" : 0,
      |      "Popularity" : 0,
      |      "OutOfDate" : null,
      |      "Maintainer" : "wenLiangcan",
      |      "FirstSubmitted" : 1431448129,
      |      "LastModified" : 1433777685,
      |      "URLPath" : "/cgit/aur.git/snapshot/mkscaladocset-hg.tar.gz"
      |    },
      |    {
      |      "ID" : 196116,
      |      "Name" : "fimpp-git",
      |      "PackageBaseID" : 76386,
      |      "PackageBase" : "fimpp-git",
      |      "Version" : "r15.61c4103-1",
      |      "Description" : "Interpreter for FIM++, an esoteric programming language inspired by the TV show My Little Pony: Friendship is Magic.",
      |      "URL" : "https://github.com/KarolS/fimpp",
      |      "NumVotes" : 1,
      |      "Popularity" : 0,
      |      "OutOfDate" : null,
      |      "Maintainer" : "applebloom",
      |      "FirstSubmitted" : 1387318403,
      |      "LastModified" : 1434298022,
      |      "URLPath" : "/cgit/aur.git/snapshot/fimpp-git.tar.gz"
      |    },
      |    {
      |      "ID" : 328499,
      |      "Name" : "ensime-server",
      |      "PackageBaseID" : 100933,
      |      "PackageBase" : "ensime-server",
      |      "Version" : "1.0.0-1",
      |      "Description" : "ENSIME server",
      |      "URL" : "https://github.com/ensime/ensime-server",
      |      "NumVotes" : 1,
      |      "Popularity" : 0,
      |      "OutOfDate" : 1522611251,
      |      "Maintainer" : "kstep",
      |      "FirstSubmitted" : 1443544783,
      |      "LastModified" : 1470820146,
      |      "URLPath" : "/cgit/aur.git/snapshot/ensime-server.tar.gz"
      |    },
      |    {
      |      "ID" : 329785,
      |      "Name" : "quine-relay",
      |      "PackageBaseID" : 87721,
      |      "PackageBase" : "quine-relay",
      |      "Version" : "r122.73e4544-1",
      |      "Description" : "Uroboros program with 100 programming languages (50 language branch)",
      |      "URL" : "http://github.com/mame/quine-relay",
      |      "NumVotes" : 2,
      |      "Popularity" : 0,
      |      "OutOfDate" : null,
      |      "Maintainer" : null,
      |      "FirstSubmitted" : 1416991575,
      |      "LastModified" : 1471260356,
      |      "URLPath" : "/cgit/aur.git/snapshot/quine-relay.tar.gz"
      |    },
      |    {
      |      "ID" : 446942,
      |      "Name" : "ensime-server-bin",
      |      "PackageBaseID" : 125909,
      |      "PackageBase" : "ensime-server-bin",
      |      "Version" : "2.0.0-1",
      |      "Description" : "ENSIME server",
      |      "URL" : "https://github.com/ensime/ensime-server",
      |      "NumVotes" : 3,
      |      "Popularity" : 1.8e-5,
      |      "OutOfDate" : null,
      |      "Maintainer" : "nekonyuu",
      |      "FirstSubmitted" : 1506515555,
      |      "LastModified" : 1506515555,
      |      "URLPath" : "/cgit/aur.git/snapshot/ensime-server-bin.tar.gz"
      |    },
      |    {
      |      "ID" : 473572,
      |      "Name" : "fgbio-git",
      |      "PackageBaseID" : 128055,
      |      "PackageBase" : "fgbio-git",
      |      "Version" : "0.4.0.r21.gc45e26f-1",
      |      "Description" : "Tools for working with genomic and high throughput sequencing data.",
      |      "URL" : "https://github.com/fulcrumgenomics/fgbio",
      |      "NumVotes" : 0,
      |      "Popularity" : 0,
      |      "OutOfDate" : null,
      |      "Maintainer" : null,
      |      "FirstSubmitted" : 1513717254,
      |      "LastModified" : 1514529377,
      |      "URLPath" : "/cgit/aur.git/snapshot/fgbio-git.tar.gz"
      |    },
      |    {
      |      "ID" : 514738,
      |      "Name" : "kaitai-struct-compiler-git",
      |      "PackageBaseID" : 132916,
      |      "PackageBase" : "kaitai-struct-compiler-git",
      |      "Version" : "0.8.r56.g078d45b-1",
      |      "Description" : "Kaitai Struct Compiler: Compiler for the Kaitai declarative binary format parsing language",
      |      "URL" : "http://kaitai.io",
      |      "NumVotes" : 0,
      |      "Popularity" : 0,
      |      "OutOfDate" : null,
      |      "Maintainer" : "mcd1992",
      |      "FirstSubmitted" : 1527627103,
      |      "LastModified" : 1527627103,
      |      "URLPath" : "/cgit/aur.git/snapshot/kaitai-struct-compiler-git.tar.gz"
      |    },
      |    {
      |      "ID" : 619762,
      |      "Name" : "bloop",
      |      "PackageBaseID" : 133763,
      |      "PackageBase" : "bloop",
      |      "Version" : "1.3.2-1",
      |      "Description" : "Bloop gives you fast edit/compile/test workflows for Scala.",
      |      "URL" : "https://scalacenter.github.io/bloop/",
      |      "NumVotes" : 6,
      |      "Popularity" : 1.661279,
      |      "OutOfDate" : null,
      |      "Maintainer" : "TheElectronWill",
      |      "FirstSubmitted" : 1529949696,
      |      "LastModified" : 1560037480,
      |      "URLPath" : "/cgit/aur.git/snapshot/bloop.tar.gz"
      |    },
      |    {
      |      "ID" : 627356,
      |      "Name" : "ammonite",
      |      "PackageBaseID" : 96818,
      |      "PackageBase" : "ammonite",
      |      "Version" : "1.6.9-1",
      |      "Description" : "A cleanroom re-implementation of the Scala REPL from first principles.",
      |      "URL" : "https://github.com/lihaoyi/Ammonite",
      |      "NumVotes" : 13,
      |      "Popularity" : 0.300672,
      |      "OutOfDate" : null,
      |      "Maintainer" : "ender4",
      |      "FirstSubmitted" : 1438937907,
      |      "LastModified" : 1562477622,
      |      "URLPath" : "/cgit/aur.git/snapshot/ammonite.tar.gz"
      |    }
      |  ]
      |}
    """.stripMargin

  val infoForBloop =
    """
      |{
      |  "version" : 5,
      |  "type" : "multiinfo",
      |  "resultcount" : 1,
      |  "results" : [
      |    {
      |      "ID" : 619762,
      |      "Name" : "bloop",
      |      "PackageBaseID" : 133763,
      |      "PackageBase" : "bloop",
      |      "Version" : "1.3.2-1",
      |      "Description" : "Bloop gives you fast edit/compile/test workflows for Scala.",
      |      "URL" : "https://scalacenter.github.io/bloop/",
      |      "NumVotes" : 6,
      |      "Popularity" : 1.661279,
      |      "OutOfDate" : null,
      |      "Maintainer" : "TheElectronWill",
      |      "FirstSubmitted" : 1529949696,
      |      "LastModified" : 1560037480,
      |      "URLPath" : "/cgit/aur.git/snapshot/bloop.tar.gz",
      |      "Depends" : [
      |        "scala",
      |        "python"
      |      ],
      |      "License" : [
      |        "Apache"
      |      ],
      |      "Keywords" : [
      |        "build",
      |        "compilation",
      |        "developer",
      |        "scala",
      |        "server"
      |      ]
      |    }
      |  ]
      |}
    """.stripMargin

  val infoForBloopAndGuix =
    """
      |{
      |  "version" : 5,
      |  "type" : "multiinfo",
      |  "resultcount" : 2,
      |  "results" : [
      |    {
      |      "ID" : 619762,
      |      "Name" : "bloop",
      |      "PackageBaseID" : 133763,
      |      "PackageBase" : "bloop",
      |      "Version" : "1.3.2-1",
      |      "Description" : "Bloop gives you fast edit/compile/test workflows for Scala.",
      |      "URL" : "https://scalacenter.github.io/bloop/",
      |      "NumVotes" : 6,
      |      "Popularity" : 1.661279,
      |      "OutOfDate" : null,
      |      "Maintainer" : "TheElectronWill",
      |      "FirstSubmitted" : 1529949696,
      |      "LastModified" : 1560037480,
      |      "URLPath" : "/cgit/aur.git/snapshot/bloop.tar.gz",
      |      "Depends" : [
      |        "scala",
      |        "python"
      |      ],
      |      "License" : [
      |        "Apache"
      |      ],
      |      "Keywords" : [
      |        "build",
      |        "compilation",
      |        "developer",
      |        "scala",
      |        "server"
      |      ]
      |    },
      |    {
      |      "ID" : 615541,
      |      "Name" : "guix",
      |      "PackageBaseID" : 69289,
      |      "PackageBase" : "guix",
      |      "Version" : "1.0.1-1",
      |      "Description" : "A purely functional package manager for the GNU system",
      |      "URL" : "https://www.gnu.org/software/guix/",
      |      "NumVotes" : 24,
      |      "Popularity" : 0.015296,
      |      "OutOfDate" : null,
      |      "Maintainer" : "lantw44",
      |      "FirstSubmitted" : 1366628787,
      |      "LastModified" : 1558709376,
      |      "URLPath" : "/cgit/aur.git/snapshot/guix.tar.gz",
      |      "Depends" : [
      |        "guile>=2.2.4",
      |        "guile-gcrypt",
      |        "guile-git-lib",
      |        "guile-sqlite3",
      |        "sqlite>=3.6.19",
      |        "bzip2",
      |        "gnutls-guile",
      |        "libgcrypt",
      |        "zlib"
      |      ],
      |      "MakeDepends" : [
      |        "bash-completion",
      |        "fish",
      |        "guile-json1",
      |        "guile-ssh>=0.10.2",
      |        "help2man"
      |      ],
      |      "OptDepends" : [
      |        "bash-completion",
      |        "guile-json1",
      |        "guile-ssh"
      |      ],
      |      "License" : [
      |        "GPL3"
      |      ],
      |      "Keywords" : [
      |        "guile",
      |        "guix",
      |        "nix",
      |        "package",
      |        "system"
      |      ]
      |    }
      |  ]
      |}
    """.stripMargin
}
