== Description

The objective of this project is to try and develop an AUR client in scala
while experimenting with some nice and cool alternatives in the ecosystem.

Currently trying to use mill, tapir and sttp and potentially zio.


== What about the name?

It seems kind standard to name scala projects like SOMETHING4s, as in something for scala.
I tried to move that around and got the nice 4saur, where aur is obviously archlinux AUR.


== I have no idea what AUR is...

It is a place that contains user submitted packages to the archlinux distribution.

  - AUR: https://wiki.archlinux.org/index.php/Arch_User_Repository
  - the API: https://wiki.archlinux.org/index.php/Aurweb_RPC_interface
  - It's code: https://git.archlinux.org/aurweb.git/
  - the site: https://aur.archlinux.org/


== Plans for the future?

If this even works maybe try to extend all of this in scope.
Would totally be nice to native compile all of it so it could be a proper application to use
regularly without the jvm in the middle.

Would be nice to put the official aur version in a docker to run tests against it.
Maybe even create a server from tapir and compare against the official one...


== Contributions?

I'm not accepting any issues, PRs or suggestions of any kind. This is mostly a thing for me to
play around for now.


== License?

I'll link it later and in correct way, but assume everything here is under AGPLv3+ and under my sole
copyright. Please respect it.