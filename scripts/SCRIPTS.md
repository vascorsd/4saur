Description of scripts included

## install-mill.sh

A simple script with a bunch of repeatable steps to actually download a mill
binary from github releases, properly install it locally in the home directory for
binaries and actually make it work as an executable.

I'm using archlinux with fish shell and the current official package is repos is broken.
So the alternative is the manual install process with adjustments.
(all because mill doesn't add a shebang to the head of file)

Assumes the following:
  - an archlinux / linux user is using this
  - sponge tool is installed (on archlinux comes in more-utils package)
  - the target binary is moved to a place that is assumed to be configured in fish_user_paths
