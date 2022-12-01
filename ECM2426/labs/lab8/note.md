lh@ML-RefVm-610797:~/dvgm$ brakeman
Loading scanner...
Processing application in /home/lh/dvgm
Processing gems...
[Notice] Detected Rails 5 application
Processing configuration...
[Notice] Escaping HTML by default
Parsing files...
Processing initializers...
Processing libs...ed
Processing routes...          
Processing templates...       
Processing data flow in templates...
Processing models...          
Processing controllers...     
Processing data flow in controllers...
Indexing call sites...        
Running checks in parallel...
 - CheckBasicAuth
 - CheckBasicAuthTimingAttack
 - CheckCrossSiteScripting
 - CheckContentTag
 - CheckCreateWith
 - CheckDefaultRoutes
 - CheckDeserialize
 - CheckDetailedExceptions
 - CheckDigestDoS
 - CheckDynamicFinders
 - CheckEscapeFunction
 - CheckEvaluation
 - CheckExecute
 - CheckFileAccess
 - CheckFileDisclosure
 - CheckFilterSkipping
 - CheckForgerySetting
 - CheckHeaderDoS
 - CheckI18nXSS
 - CheckJRubyXML
 - CheckJSONEncoding
 - CheckJSONParsing
 - CheckLinkTo
 - CheckLinkToHref
 - CheckMailTo
 - CheckMassAssignment
 - CheckMimeTypeDoS
 - CheckModelAttrAccessible
 - CheckModelAttributes
 - CheckModelSerialize
 - CheckNestedAttributes
 - CheckNestedAttributesBypass
 - CheckNumberToCurrency
 - CheckPermitAttributes
 - CheckQuoteTableName
 - CheckRedirect
 - CheckRegexDoS
 - CheckRender
 - CheckRenderDoS
 - CheckRenderInline
 - CheckResponseSplitting
 - CheckRouteDoS
 - CheckSafeBufferManipulation
 - CheckSanitizeMethods
 - CheckSelectTag
 - CheckSelectVulnerability
 - CheckSend
 - CheckSendFile
 - CheckSessionManipulation
 - CheckSessionSettings
 - CheckSimpleFormat
 - CheckSingleQuotes
 - CheckSkipBeforeFilter
 - CheckSprocketsPathTraversal
 - CheckSQL
 - CheckSQLCVEs
 - CheckSSLVerify
 - CheckStripTags
 - CheckSymbolDoSCVE
 - CheckTranslateBug
 - CheckUnsafeReflection
 - CheckValidationRegex
 - CheckWithoutProtection
 - CheckXMLDoS
 - CheckYAMLParsing
Checks finished, collecting results...
Generating report...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9
:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
Session Setting: 1

:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
Session Setting: 1

== Warnings ==

:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
Session Setting: 1

== Warnings ==

Confidence: High
Category: Cross-Site Scripting
Check: CrossSiteScripting
Message: Unescaped model attribute
Code: Grade.new.comment
:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
Session Setting: 1

== Warnings ==

Confidence: High
Category: Cross-Site Scripting
Check: CrossSiteScripting
Message: Unescaped model attribute
Code: Grade.new.comment
File: app/views/grades/index_admin.html.erb
:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
Session Setting: 1

== Warnings ==

Confidence: High
Category: Cross-Site Scripting
Check: CrossSiteScripting
Message: Unescaped model attribute
Code: Grade.new.comment
File: app/views/grades/index_admin.html.erb
Line: 25
:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
Session Setting: 1

== Warnings ==

Confidence: High
Category: Cross-Site Scripting
Check: CrossSiteScripting
Message: Unescaped model attribute
Code: Grade.new.comment
File: app/views/grades/index_admin.html.erb
Line: 25

:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
Session Setting: 1

== Warnings ==

Confidence: High
Category: Cross-Site Scripting
Check: CrossSiteScripting
Message: Unescaped model attribute
Code: Grade.new.comment
File: app/views/grades/index_admin.html.erb
Line: 25

Confidence: High
:...skipping...

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
Session Setting: 1

== Warnings ==

Confidence: High
Category: Cross-Site Scripting
Check: CrossSiteScripting
Message: Unescaped model attribute
Code: Grade.new.comment
File: app/views/grades/index_admin.html.erb
Line: 25

Confidence: High
Category: Cross-Site Scripting

== Brakeman Report ==

Application Path: /home/lh/dvgm
Rails Version: 5.2.6
Brakeman Version: 4.4.0
Scan Date: 2022-12-01 14:42:40 +0000
Duration: 1.30238116 seconds
Checks Run: BasicAuth, BasicAuthTimingAttack, ContentTag, CreateWith, CrossSiteScripting, DefaultRoutes, Deserialize, DetailedExceptions, DigestDoS, DynamicFinders, EscapeFunction, Evaluation, Execute, FileAccess, FileDisclosure, FilterSkipping, ForgerySetting, HeaderDoS, I18nXSS, JRubyXML, JSONEncoding, JSONParsing, LinkTo, LinkToHref, MailTo, MassAssignment, MimeTypeDoS, ModelAttrAccessible, ModelAttributes, ModelSerialize, NestedAttributes, NestedAttributesBypass, NumberToCurrency, PermitAttributes, QuoteTableName, Redirect, RegexDoS, Render, RenderDoS, RenderInline, ResponseSplitting, RouteDoS, SQL, SQLCVEs, SSLVerify, SafeBufferManipulation, SanitizeMethods, SelectTag, SelectVulnerability, Send, SendFile, SessionManipulation, SessionSettings, SimpleFormat, SingleQuotes, SkipBeforeFilter, SprocketsPathTraversal, StripTags, SymbolDoSCVE, TranslateBug, UnsafeReflection, ValidationRegex, WithoutProtection, XMLDoS, YAMLParsing

== Overview ==

Controllers: 7
Models: 7
Templates: 21
Errors: 0
Security Warnings: 9

== Warning Types ==

Cross-Site Scripting: 4
Mass Assignment: 1
SQL Injection: 3
Session Setting: 1

## attention
== Warnings ==

Confidence: High
Category: Cross-Site Scripting
Check: CrossSiteScripting
Message: Unescaped model attribute
Code: Grade.new.comment
File: app/views/grades/index_admin.html.erb
Line: 25

Confidence: High
Category: Cross-Site Scripting
Check: CrossSiteScripting
Message: Unescaped model attribute
Code: Grade.new.comment
File: app/views/grades/index_lecturer.html.erb
Line: 25

Confidence: High
Category: SQL Injection
Check: SQL
Message: Possible SQL injection
Code: User.where("session = '#{cookies[:session]}' and session not NULL")
File: app/controllers/application_controller.rb
Line: 24

```
Confidence: High
Category: SQL Injection
Check: SQL
Message: Possible SQL injection
Code: Grade.joins(:lecture => :lecturer).where("grades.student_id = #{current_user.id.to_s} AND users.login LIKE '%#{params[:lecturer]}%'")
File: app/controllers/grades_controller.rb
Line: 24
```

Confidence: High
Category: Session Setting
Check: SessionSettings
Message: Session secret should not be included in version control
File: config/secrets.yml
Line: 22

Confidence: Medium
Category: Cross-Site Scripting
Check: SanitizeMethods
Message: loofah gem 2.0.3 is vulnerable (CVE-2018-8048). Upgrade to 2.1.2
File: Gemfile.lock
Line: 75

Confidence: Medium
Category: Cross-Site Scripting
Check: SanitizeMethods
Message: rails-html-sanitizer 1.0.3 is vulnerable (CVE-2018-3741). Upgrade to rails-html-sanitizer 1.0.4
File: Gemfile.lock
Line: 115

Confidence: Medium
Category: Mass Assignment
Check: PermitAttributes
Message: Potentially dangerous key allowed for mass assignment
Code: params.require(:user).permit(:login, :role, :password, :password_confirmation)
File: app/controllers/users_controller.rb
Line: 81

Confidence: Medium
Category: SQL Injection
Check: SQL
Message: Possible SQL injection
Code: User.where("users.login = '#{user_session_params[:login]}' AND users.password = '#{Digest::MD5.hexdigest(user_session_params[:password])}'")
File: app/controllers/user_sessions_controller.rb
Line: 4

## last section
issues with '''(not well closed)

LIKE '%%' OR user.login LIKE ' XXXX'%'
%' OR 1=1 ) --
