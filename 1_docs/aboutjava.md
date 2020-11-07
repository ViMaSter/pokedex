# [Java](https://en.wikipedia.org/wiki/Java_(programming_language))
Programming language (vocabulary and set of grammatical rules)

Something a "compiler" can <abbr title="zusammentragen">compile</abbr> into processor instructions.

# Eclipse
[**IDE**](https://en.wikipedia.org/wiki/Integrated_development_environment)  
integrated development environment  
**development environment** = tools needed to <abbr title="text editor">create</abbr>, <abbr title="text editor">navigate</abbr>, <abbr title="compiler">compile</abbr>, <abbr title="Java Runtime">execute</abbr> and <abbr title="jdb.exe">debug code</abbr>  
**integrated** development environment = a pre-configured "bundle" of tools

# Dynamic Web Project
Subset of predefined logic, classes and behavior to aid with generating HTTP requests

# Static Web Project
Simple "file server" via HTTP

# [HTTP](https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol)
Hypertext transfer protocol; text communication protocol between browsers and (web) servers

## Example request
```
GET / HTTP/1.1
Host: www.example.com
```

## Example response
```
HTTP/1.1 200 OK
Date: Mon, 23 May 2005 22:38:34 GMT
Content-Type: text/html; charset=UTF-8
Content-Length: 155
Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
ETag: "3f80f-1b6-3e1cb03b"
Accept-Ranges: bytes
Connection: close

<html>
  <head>
    <title>An Example Page</title>
  </head>
  <body>
    <p>Hello World, this is a very simple HTML document.</p>
  </body>
</html>
```

# Enterprise Application
Java itself has a set of predefined standards; called the "Java Platform, Standard Edition" (short Java SE). Sun (now owned by Oracle) is where the original and reference implementation was developed. (What is a class? What is a field? What is a variable? What is a value? How can timestamps be stored?, etc.)  
Most of it is now licenced under the "GNU General Public Licence" (The GNU Project = group of people that now maintain the Linux kernel source code)  
OpenJDK is the current reference implementation of the Java Platform, Standard Edition.
Java Enterprise Edition is the old name for "Jakarta EE", which is a set of specifications extending the Java SE 8. (I.e. e-commerce, accounting, banking information systems.)
An enterprise application is a Java app, that utilizes not only Java SE, but Jakarta EE.

# Application Server
## Application
A piece of executable logic + data definitions

## Application Server
An environment, that allows (multiple) applications to be run (i.e. WildFly, Tomcat, WebSphere, etc.)

# Working set
Group of eclipse projects

# Context root
Name of the "first folder" inside the URL that will map to our app
# Content directory
Name of the physical folder on our machine that will be mapped to our Context root (JSPs, images, CSS, etc.)

# JavaServer Faces (JSF) & JSP file
## JSF
Hybrid-syntax of java-specific HTML
## JSP
Clear separation between HTML and Java code via `<% %>`

