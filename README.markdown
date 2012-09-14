<h2>Read me first</h2>

<p>The license of this project is LGPLv3 or later. See file
src/main/resources/LICENSE for the full text.</p>

<h2>What it is</h2>

<p>This is a sister project to <a
href="https://github.com/fge/json-schema-validator">json-schema-validator</a>,
which handles all format attributes not supported by json-schema-validator
proper. See below for the list of added format attributes.</p>

<h2>Versions</h2>

<p>Two versions exist, which match the stable versions of json-schema-validator
(along with Maven requirements):</p>

<ul>
    <li>1.2.0,</li>
    <li>1.0.1.</li>
</ul>

<h2>List of format attributes</h2>

<p>This is the list of format attributes supported by this package. The first
four of them are defined by draft v3:</p>

* <tt>date</tt>,
* <tt>time</tt>,
* <tt>phone</tt>,
* <tt>utc-millisec</tt>,
* <tt>base64</tt>,
* <tt>date-time-ms</tt> (ISO 8601 date format, with millisecond precision),
* <tt>md5</tt>,
* <tt>sha1</tt> (yes, git commit IDs use that),
* <tt>sha256</tt>,
* <tt>sha512</tt>,
* <tt>mac</tt>.

<p>As the time goes, some more attributes are added. See the <a
href="https://github.com/fge/json-schema-formats/wiki">wiki</a> for more
information.</p>

<h2>What about the other ones?</h2>

<p>Here is a list of other attributes defined by the currently active draft,
but which are in the core package for various reasons:</p>

* <tt>uri</tt>: necessary for validating schemas (if you don't have it, you
  cannot validate <tt>$ref</tt>, <tt>id</tt> or <tt>$schema</tt> for instance);
* <tt>regex</tt>: for compliance reasons (recall: the draft dictates ECMA 262
  for regexes);
* <tt>host-name</tt>, <tt>ip-address</tt>, <tt>email</tt>, <tt>date-time</tt>:
  those are attributes which will see the widest use, it makes no sense to
  require a separate package to support these.

<p>You will have noticed the absence of the <tt>color</tt> and <tt>style</tt>
format attributes. While defined by the draft, I believe them to be of no
practical use and have chosen not to support them at all.</p>

