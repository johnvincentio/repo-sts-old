[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building natural-programmer-spring-sample-8 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ sample ---
[INFO] Deleting /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ sample ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ sample ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 9 source files to /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/target/classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MockMailSender.java:[3,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MailSender.java:[3,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MockMailSender.java:[24,73] cannot find symbol
  symbol:   class MessagingException
  location: class com.naturalprogrammer.spring.sample.mail.MockMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MailSender.java:[7,82] cannot find symbol
  symbol:   class MessagingException
  location: interface com.naturalprogrammer.spring.sample.mail.MailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/core/MailerController.java:[3,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/core/MailerController.java:[29,41] cannot find symbol
  symbol:   class MessagingException
  location: class com.naturalprogrammer.spring.sample.core.MailerController
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/core/MailController.java:[4,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/core/MailController.java:[22,41] cannot find symbol
  symbol:   class MessagingException
  location: class com.naturalprogrammer.spring.sample.core.MailController
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[3,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[4,27] package javax.mail.internet does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[8,41] package org.springframework.mail.javamail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[9,41] package org.springframework.mail.javamail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[18,17] cannot find symbol
  symbol:   class JavaMailSender
  location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[19,40] cannot find symbol
  symbol:   class JavaMailSender
  location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[24,73] cannot find symbol
  symbol:   class MessagingException
  location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MailConfig.java:[6,41] package org.springframework.mail.javamail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MailConfig.java:[26,42] cannot find symbol
  symbol:   class JavaMailSender
  location: class com.naturalprogrammer.spring.sample.mail.MailConfig
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[25,17] cannot find symbol
  symbol:   class MimeMessage
  location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[26,17] cannot find symbol
  symbol:   class MimeMessageHelper
  location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[26,48] cannot find symbol
  symbol:   class MimeMessageHelper
  location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[INFO] 20 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.286 s
[INFO] Finished at: 2015-08-17T13:40:13-04:00
[INFO] Final Memory: 21M/304M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project sample: Compilation failure: Compilation failure:
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MockMailSender.java:[3,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MailSender.java:[3,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MockMailSender.java:[24,73] cannot find symbol
[ERROR] symbol:   class MessagingException
[ERROR] location: class com.naturalprogrammer.spring.sample.mail.MockMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MailSender.java:[7,82] cannot find symbol
[ERROR] symbol:   class MessagingException
[ERROR] location: interface com.naturalprogrammer.spring.sample.mail.MailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/core/MailerController.java:[3,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/core/MailerController.java:[29,41] cannot find symbol
[ERROR] symbol:   class MessagingException
[ERROR] location: class com.naturalprogrammer.spring.sample.core.MailerController
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/core/MailController.java:[4,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/core/MailController.java:[22,41] cannot find symbol
[ERROR] symbol:   class MessagingException
[ERROR] location: class com.naturalprogrammer.spring.sample.core.MailController
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[3,18] package javax.mail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[4,27] package javax.mail.internet does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[8,41] package org.springframework.mail.javamail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[9,41] package org.springframework.mail.javamail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[18,17] cannot find symbol
[ERROR] symbol:   class JavaMailSender
[ERROR] location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[19,40] cannot find symbol
[ERROR] symbol:   class JavaMailSender
[ERROR] location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[24,73] cannot find symbol
[ERROR] symbol:   class MessagingException
[ERROR] location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MailConfig.java:[6,41] package org.springframework.mail.javamail does not exist
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/MailConfig.java:[26,42] cannot find symbol
[ERROR] symbol:   class JavaMailSender
[ERROR] location: class com.naturalprogrammer.spring.sample.mail.MailConfig
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[25,17] cannot find symbol
[ERROR] symbol:   class MimeMessage
[ERROR] location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[26,17] cannot find symbol
[ERROR] symbol:   class MimeMessageHelper
[ERROR] location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] /Users/jv/Desktop/MyDevelopment/repo_sts/sts/course-basic-spring/natural-programmer-spring-sample-8/src/main/java/com/naturalprogrammer/spring/sample/mail/SmtpMailSender.java:[26,48] cannot find symbol
[ERROR] symbol:   class MimeMessageHelper
[ERROR] location: class com.naturalprogrammer.spring.sample.mail.SmtpMailSender
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
