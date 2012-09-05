<h2>Read me first</h2>

<p>The license of this project is LGPLv3 or later. See file
src/main/resources/LICENSE for the full text.</p>

<p><b>Version 1.0.0 is now on Maven Central</b>. It requires version 1.0.2 of
json-schema-validator, ie the latest in the 1.0.x series, which is also on Maven
central.</p>

<h2>What it is</h2>

<p>This is a sister project to <a
href="https://github.com/fge/json-schema-validator">json-schema-validator</a>,
which handles all format specifiers not supported by json-schema-validator
proper. The list of specifiers moved from the main package is:</p>

* <tt>date</tt>,
* <tt>time</tt>,
* <tt>phone</tt>,
* <tt>utc-millisec</tt>,
* <tt>date-time-ms</tt>.

<p>The latter format specifier is not defined by the draft. It is a custom
format specifier (authored by Corey Sciuto) which is equivalent to
<tt>date-time</tt>, except augmented with milliseconds precision.</p>

<p>As the time goes, some more specifiers are added. See the list of proposed
specifiers on the <a
href="https://github.com/fge/json-schema-formats/wiki">wiki</a>.</p>

<h2>What about the other ones?</h2>

<p>Here is a list of other specifiers defined by the currently active draft,
but which are in the core package for various reasons:</p>

* <tt>uri</tt>: necessary for validating schemas (if you don't have it, you
  cannot validate <tt>$ref</tt>, <tt>id</tt> or <tt>$schema</tt> for instance);
* <tt>regex</tt>: for compliance reasons (recall: the draft dictates ECMA 262
  for regexes);
* <tt>host-name</tt>, <tt>ip-address</tt>, <tt>email</tt>, <tt>date-time</tt>:
  those are specifiers which will see the widest use, it makes no sense to
  require a separate package to support these.

<p>You will have noticed the absence of the <tt>color</tt> and <tt>style</tt>
format specifiers. While defined by the draft, I believe them to be of no
practical use and have chosen not to support them at all.</p>

<p>All in all, this project handles format specifiers which, either:</p>

* are not critical to JSON Schema proper, or
* will likely be much less used than the above.

<p>It is also a good opportunity to experiment with new format specifiers.
Feature requests welcome!</p>
