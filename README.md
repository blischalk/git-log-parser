# git-log-parser

A Clojure command line app designed to parse git log data.

## Usage

execute `git log --graph --pretty=format':%C%h%Cblue%d%Creset %s %C %an, %ar%Creset'` | java -jar git-log-parser-1.0.0-standalone.jar

## License

Copyright © 2014 Brett Lischalk

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
