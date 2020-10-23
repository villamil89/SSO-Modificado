FROM registry.redhat.io/redhat-sso-7/sso72-openshift:1.2
COPY todeploy/soaint-sso-custom-login-jar-with-dependencies.jar $JBOSS_HOME/standalone/deployments/
#USER root
#RUN chown jboss:jboss $JBOSS_HOME/standalone/deployments/soaint-sso-custom-login-jar-with-dependencies.jar
#USER jboss
