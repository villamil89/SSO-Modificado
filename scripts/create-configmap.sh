oc create -f - <<EOF
apiVersion: v1
kind: ConfigMap
data:
  soaint-sic-authertication.properties: |-
    conexion-actor-id=1
    conexion-actor-descripcion=SOAINT
    conexion-actor-llaveExterna=1
    conexion-usuario=5fb0dabb1ad70d9cd99da567f785ed1d
    conexion-password=80d5de954264f0bda2f3a0a99737814c
    conexion-servicio=3
    bd-string-url=
    bd-nombre-servidor=10.20.101.168
    bd-numero-puerto=12001
    bd-sid=business
    bd-usuario=CORRESPONDENCIA
    bd-password=S1c2019
    load-once=false
    show-password=true
    nonstatic-common-group=admin,analyst,developer,manager,process-admin,user,rest-all,kie-server
    static-users-business=super-admin,fakeuser,admin,analyst,developer,manager,process-admin,user,rest-all,kie-server
    static-users-kie=mavenUser,controllerUser,adminUser,executionUser
    groups-for-super-admin=admin,analyst,developer,manager,process-admin,user,rest-all,kie-server
    groups-for-fakeuser=role1,process-admin,manager,admin,analyst,rest-all,developer,rest-project,user
    groups-for-mavenUser=rest-all,user
    groups-for-executionUser=rest-all,user
    groups-for-controllerUser=rest-all,user
    groups-for-adminUser=rest-all,admin
    groups-for-admin=admin
    password-for-admin=admin
    groups-for-analyst=analyst
    password-for-analyst=analyst
    groups-for-developer=developer
    password-for-developer=developer
    groups-for-manager=manager
    password-for-manager=manager
    groups-for-process-admin=process-admin
    password-for-process-admin=process-admin
    groups-for-user=user
    password-for-user=user
    groups-for-rest-all=rest-all
    password-for-rest-all=rest-all
    groups-for-kie-server=kie-server
    password-for-kie-server=kie-server
    system-call=true
    DEBUG=true
metadata:
  name: soaint-sic-authertication.properties
EOF

