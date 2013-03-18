<h2>Read me first</h2>

<p>The license of this project is LGPLv3 or later. See file
src/main/resources/LICENSE for the full text.</p>

<h2>What it is</h2>

<p>This is a project implementing format attributes not included in the JSON Schema drafts, which
can be used to extend the validation capabilities of <a
href="https://github.com/fge/json-schema-validator">json-schema-validator</a>.</p>

<h2>Versions</h2>

<p>The current version is <b>2.0.0</b>.

<h2>Maven artifact</h2>

<p>Replace <tt>your-version-here</tt> with the appropriate version:</p>

```xml
<dependency>
    <groupId>com.github.fge</groupId>
    <artifactId>json-schema-formats</artifactId>
    <version>your-version-here</version>
</dependency>
```

<h2>Sample usage</h2>

<p>This package comes with a dictionary of all defined format attributes. In order to use it, you
need to create your own keyword library and add the format attributes you want to it. For instance,
here is how you add the <tt>sha1</tt> format attribute:</p>

```java
final Dictionary<FormatAttribute> dict = ExtraFormatsDictionary.get();
                
final LibraryBuilder lib = DraftV4Library.get().thaw();
lib.addFormatAttribute("json-pointer", dict.entries().get("json-pointer"));
                                        
final ValidationConfigurationBuilder cfg = ValidationConfiguration.newBuilder();
cfg.addLibrary("foo://bar", lib.freeze());

final JsonSchemaFactory factory = JsonSchemaFactory.newBuilder()
    .setValidationConfiguration(cfg.freeze()).freeze();

// Now use the factory
```

<h2>List of format attributes</h2>

<p>This is the list of format attributes supported by this package.:</p>

* <tt>base64</tt>,
* <tt>md5</tt>,
* <tt>sha1</tt> (yes, git commit IDs use that),
* <tt>sha256</tt>,
* <tt>sha512</tt>,
* <tt>mac</tt>,
* <tt>json-pointer</tt>,
* <tt>uri-template</tt>.

<p>See the <a href="https://github.com/fge/json-schema-formats/wiki">wiki</a> for more
information.</p>

