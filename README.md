WebChat
=======

A Webbyfied connector for the ECF Chat application that uses OSGi remote services (http://wiki.eclipse.org/OSGi_Remote_Services_and_ECF) at its heart. It does not target existing chat networks or protocols.

Requirements
============
Chat application and its model: https://github.com/ECF/Chat
Apache Felix whiteboard: http://www.lemmster.de/blog/index.php/2013/12/11/1496

At runtime, the following bundles are needed (with Equinox/Jetty/Apache Whiteboard/ECF Zookeeper & generic):

<pre>
osgi> ss 
"Framework is launched."

id	State       Bundle
0	ACTIVE      org.eclipse.osgi_3.10.0.v20131210-2136
	            Fragments=17
1	ACTIVE      org.eclipse.ecf.sharedobject_2.4.0.v20131027-1505
2	ACTIVE      org.eclipse.ecf_3.2.0.v20131027-1505
	            Fragments=28
3	ACTIVE      org.eclipse.core.runtime_3.10.0.v20131008-1415
4	ACTIVE      org.eclipse.core.contenttype_3.4.200.v20130326-1255
5	ACTIVE      org.eclipse.ecf.identity_3.2.0.v20131027-1505
6	ACTIVE      org.apache.hadoop.zookeeper_3.3.3.v201105210832
7	ACTIVE      org.eclipse.equinox.util_1.0.500.v20130404-1337
8	ACTIVE      org.eclipse.ecf.provider.remoteservice_4.0.100.v20131027-1505
9	ACTIVE      org.apache.felix.gogo.runtime_0.10.0.v201209301036
10	ACTIVE      org.eclipse.ecf.osgi.services.distribution_2.0.300.v20131027-1505
11	ACTIVE      org.apache.log4j_1.2.15.v201012070815
12	ACTIVE      org.eclipse.ecf.discovery_4.0.0.v20131027-1505
13	ACTIVE      org.eclipse.ecf.osgi.services.remoteserviceadmin.proxy_1.0.0.v20131027-1505
14	ACTIVE      org.eclipse.ecf.example.chat.web_1.0.0.qualifier
15	ACTIVE      org.eclipse.ecf.provider_4.4.0.v20131027-1505
16	ACTIVE      org.eclipse.equinox.app_1.3.200.v20130910-1609
17	RESOLVED    org.eclipse.osgi.compatibility.state_1.0.0.v20131023-1243
	            Master=0
18	ACTIVE      org.eclipse.equinox.preferences_3.5.100.v20130422-1538
19	ACTIVE      org.apache.felix.gogo.command_0.10.0.v201209301215
20	ACTIVE      org.eclipse.core.jobs_3.5.400.v20130717-1327
21	ACTIVE      org.eclipse.equinox.common_3.6.200.v20130402-1505
22	RESOLVED    org.eclipse.core.runtime.compatibility.registry_3.5.300.v20130916-1243
	            Master=25
23	ACTIVE      org.eclipse.ecf.osgi.services.remoteserviceadmin_3.0.0.v20131027-1505
24	ACTIVE      org.eclipse.equinox.console_1.1.0.v20131021-1843
25	ACTIVE      org.eclipse.equinox.registry_3.5.400.v20130717-1325
	            Fragments=22
26	ACTIVE      org.eclipse.jetty.continuation_8.1.12.v20130726
27	ACTIVE      org.eclipse.osgi.services_3.4.0.v20131120-1328
28	RESOLVED    org.eclipse.ecf.ssl_1.1.0.v20131027-1505
	            Master=2
29	ACTIVE      javax.servlet_3.0.0.v201112011016
30	ACTIVE      org.eclipse.osgi.services.remoteserviceadmin_1.5.0.v20131027-1505
31	ACTIVE      javax.xml_1.3.4.v201005080400
32	ACTIVE      org.eclipse.equinox.concurrent_1.1.0.v20130327-1442
33	ACTIVE      org.eclipse.ecf.example.chat.model_1.0.0.qualifier
34	ACTIVE      org.eclipse.ecf.provider.zookeeper_1.0.100.v20131027-1505
35	ACTIVE      org.eclipse.ecf.remoteservice_8.2.0.v20131027-1505
36	ACTIVE      org.apache.felix.gogo.shell_0.10.0.v201212101605
37	ACTIVE      org.eclipse.jetty.server_8.1.12.v20130726
38	ACTIVE      org.eclipse.jetty.http_8.1.12.v20130726
39	ACTIVE      org.apache.felix.http.api_2.2.2
40	ACTIVE      org.eclipse.jetty.io_8.1.12.v20130726
41	ACTIVE      org.eclipse.jetty.util_8.1.12.v20130726
42	ACTIVE      org.eclipse.equinox.http.servlet_1.1.400.v20130418-1354
43	ACTIVE      org.eclipse.jetty.servlet_8.1.12.v20130726
44	ACTIVE      org.apache.felix.http.whiteboard_2.2.2
45	ACTIVE      org.eclipse.jetty.security_8.1.12.v20130726
46	ACTIVE      org.eclipse.equinox.http.jetty_3.0.200.v20131021-1843
47	ACTIVE      org.eclipse.equinox.ds_1.4.200.v20131126-2331
</pre>
