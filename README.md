# grails3-rest-api-mysql-starter
starter project layout for grails 3.1.4 for a rest api micro service using mysql for database tier

create initial grails project
<pre><code>grails create-app com.xyz.package1.gorm --profile=reat-api</code></pre>

install MySQL connector, in build.gradle add 
<pre><code>runtime('mysql:mysql-connector:5.1.29')</code></pre>
