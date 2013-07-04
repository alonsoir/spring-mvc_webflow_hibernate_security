a development diary, sorry for the spanish, i was born in badajoz, spain in 1977, by the way :)

30 de mayo 2013

a dia de hoy, los flujos estan definidos en fincas-morosas-flow.xml, hay daos y servicio de comunidades, 
faltan los daos y servicios para el resto de entidades, la seguridad la tienes definida en security.xml, 
tienes que ver como personalizar ese dialogo de login que provee, de la misma forma para el logout.
Los usuarios estan hardcodeados en security.xml, no mola eso. Pero tienes seguridad! 
La validacion no la tienes muy bien, tienes una clase ComunidadVecinosValidator pero no creo que este funcionando

En la declaracion del flujo, en las entidades view-state tienes hecho el binding y ahi pones si un campo es requerido o no
pero no tengo manera ahora de poder poner un mensajito en la vista, es decir, no tengo acceso al mapa desde donde se puede 
acceder desde la jsp a las cosas variables que se calculan en el servicio.


A dia de hoy se realiza la insercion en la primera entidad y puedo seguir navegando, que no es poco.

Los controladores gestionados por spring mvc no los estas usando, y mejor asi, pq tal y como los tienes, si se invocan
en medio de un flujo, se descuajaringa

http://md5.rednoize.com esta web sirve para calcular el md5 de lo que introduzcas

creo que te sobra totalmente ese validator, o lo tienes mal, o no lo esta procesando, Necesitas poder validar 

OJITO a esto:

log4j:WARN No appenders could be found for logger (org.springframework.web.context.ContextLoader).
log4j:WARN Please initialize the log4j system properly.
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.

[WARNING] Some problems were encountered while building the effective model for com.aironman.jocalons:SpringMVC:war:1.0-SNAPSHOT
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.springframework:spring-web:jar -> duplicate declaration of version ${spring.version} @ line 206, column 15
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 252, column 12

Tienes que poder generar un doc, para ello tendras que tirar de la plantilla que hicistes con el jasper

REFERENCIAS a mirar

http://static.springsource.org/spring-webflow/docs/2.3.x/reference/htmlsingle/spring-webflow-reference.html#view-validate

http://static.springsource.org/spring-security/site/docs/3.2.x/reference/ns-config.html

http://static.springsource.org/spring-webflow/docs/2.3.2.RELEASE/reference/html/

Ya tienes seguridad con spring security, tienes incluso soporte para reglas acl y las tablas necesarias.

3 de junio
has cambiado el orden del flujo, ahora lo tienes asi:

 Comunidades -> moroso -> fincasmorosas -> juntas -> certificados
la razon es que las entidades primeras son padre de fincasmorosas y es mejor hacer un insert que varios updates. Por esa misma razon, el orden deberia 
ser el siguiente:

juntas -> Comunidades -> moroso -> fincasmorosas -> certificados

La razon es que Comunidades depende de juntas, fincasmorosas depende de Comunidades y moroso y por ultimo certificado no depende de nadie, es decir, no
hay fks que rellenar.

Para hoy vas a cambiar el orden del flujo para que sea asi, que es mas correcto y tambien vas a conseguir el componente jquery que calcula la fecha. HECHO!


estas guardandando en todas las entidades, salvo que:
	en juntas 
		 necesitas un componente jquery para la fecha SOLUCIONADO
		 no se esta guardando los campos de la vista, se genera una tupla con el id lleno pero los otros dos no SOLUCIONADO
	en certificados
		hay que definir esto, en ppio voy a mostrar toda la informacion que he recogido anteriormente y dos botones,
		uno para generar la demanda, para ello necesitaremos servicios y daos y otro para contactar con jorge
		
Como es el proceso de crear el usuario con permisos de manipular el flujo y hacer login?
Que debe salir en la pagina inicial index1? un listado de las demandas asignadas a determinado abogado, 
el estado de la misma, el nombre del moroso, la cuantia de la deuda. Algo mas? quien va a ver esta informacion? 
solo Jorge, por lo que para el le dare el ROLE_ADMIN. Necesitara un servicio y un dao especifico
Como es el proceso de contactar con jorge?
Como es el proceso para asignar un abogado para la demanda? 
Tienes que definir una pagina login, puede que adaptar UserService,crear el dao, 


Has empezado a hacer lo necesario para generar el pdf o el doc. Tienes que resolver dependencias, ahora mismo da:

[ERROR] Failed to execute goal on project SpringMVC: Could not resolve dependencies for project com.aironman.jocalons:SpringMVC:war:1.0-SNAPSHOT: 
Failure to find com.lowagie:itext:jar:2.1.7.js1 in http://localhost:8081/nexus/content/groups/public 
was cached in the local repository, resolution will not be reattempted until the update interval of nexus has elapsed or updates are forced -> [Help 1]

con esta consulta sacas la informacion necesaria para poder generar el documento. Como vas a mostrar el resumen? en ppio desde el flujo tienes acceso a todos
los pojos, que mantienen esa informacion que quieres mostrar. Estas seguro de eso????? No
<![CDATA[select mor.cp as CP_MOROSO, 
       mor.direccion as DIRECCION_MOROSO,
       mor.nifcif as NIFCIF_MOROSO,
       mor.nombre AS NOMBRE_MOROSO,
       mor.telefono AS TLF_MOROSO,
       mor.ciudad AS CIUDAD_MOROSO,
       comunidad.ciudad AS CIUDAD_COMUNIDAD,
       comunidad.nombrecomunidad AS NOMBRE_COMUNIDAD,
       comunidad.direccion AS DIRECCION_COMUNIDAD,
       comunidad.adminfincas AS ADMIN_COMUNIDAD,
       comunidad.presidente AS PRESI_COMUNIDAD,
       juntas.fechacelebracion AS FECHA_CELEBRACION_JUNTAS,
       juntas.textolibre AS TEXTO_LIBRE_JUNTAS
from comunidadvecinos as comunidad, viviendascondeudas as vivi,moroso as mor,juntas_ordinarias as juntas
where comunidad.junta_idjunta = juntas.idjunta              AND
      comunidad.refcatastral  = vivi.comunidad_refcatastral AND
      mor.idmoroso = vivi.moroso_idmoroso                   AND
      vivi.iddeuda=$P{IDDEUDA}]]>

      
has modificado el jquery de juntas.jsp, la definicion del componente fecha y el pojo JuntasOrdinarias, tienes que probarlo, pero antes tendrias que 
resolver las dependencias, ahora lo tienes roto.. HECHO

5 de junio 



6 de junio
  
Necesitas que se vean las imagenes! has modificado cosas en el applicationContext, pero aun nada

Necesitas validacion de los campos, que tengan el tama�o adecuado por ejemplo! HECHO!

hoy ya tienes un servicio que hace la generacion de un pdf, ahora tienes hardcodeado el idDeuda necesario para generar el pdf.
Necesito poder pasar el idDeuda entre los flujos, para ello tienes que ver bien esto:

http://static.springsource.org/spring-webflow/docs/2.0.x/reference/html/ch03s05.html OK!!

OJITO Cuando se genera el pdf, te esta dando un error Exception in thread "AWT-EventQueue-0" java.lang.OutOfMemoryError: PermGen space -Xmx1024M?
como se lo paso a maven? o al jetty?
igual se arregla dando mas memoria, -Xmx1024M. En ppio lo has solucionado a�adiendo la entrada siguiente:

MAVEN_OPTS=-server -XX:MaxPermSize=512M -ms1024M -mx1024M -XX:AppendRatio=3
export MAVEN_OPTS

en el fichero $HOME/.bash_profile No tengo claro que con esto se solucione, ahora se genera mas o menos bien el pdf, falla la fecha que pillas de la junta de 
vecinos, sale un null, igual tienes que modificar la plantilla, ojito cuando la modifiques!





10 de junio
has modificado la plantilla para la fecha la tome como una cadena, en el pojo juntas has modificado tambien la fecha
para qe sea una cadena. tienes que a�adir usuarios  a las tablas del esquema de seguridad, tienes pojos para asegurarte de no
perderlo nunca, en ppio no tienes que modificar o crear ningun dao para esta seguridad, te vale ese esquema. Necesitas
hacer algo con la pantalla de login, ahora el loginid forma parte de comunidadvecinos, para saber cuales pertenecen
a cual, de forma que tendras que pasar el user logado para crear la comunidad, haz que ese campo sea obligatorio a nivel de
tablas. Al final necesitaremos que el usuario con perfil user_admin_fincas pueda ver las comunidades que tenga abiertas por el.

Jorge tambien tendra que ver algo parecido...

no me convence nada como se esta mostrando el pdf al cliente, mejor seria darle un html, menos costoso seguro. tienes codigo para ello, probarlo
OJO, tambien has modificado el servicio de las comunidades para que pille el usuario logado mediante spring security. TIENES QUE PROBARLO!

tienes que saber si los pojos que se usan en cada uno de los estados del flujo, pueden ser usados en algun punto del flujo
mas que nada pq quieres que en el ultimo paso se vea un resumen de la informacion que has introducido en las tablas
JuntaVecinos, comunidadvecinos, moroso y FincasMorosas. has puesto en la definicion del flujo una condicion onrender
<on-render>
        	<evaluate expression="certificadosService.traerInfoParaCertificado(conversationScope.mensajeFinca)"
                  result="viewScope.infoCertificado" />
    	</on-render>
		
tienes que picar el metodo, que haga la misma consulta que hago para generar el doc, el resultado la devolvere en una cadena
y la ponder en el viewscope para poder ser renderizada en la vista.  

11 de junio

hoy no te ha salido nada de nada. Ahora la seguridad no te deja entrar! has cogido esto 

http://www.mkyong.com/spring-security/spring-security-form-login-using-database/

en ppio funciona, ahora que te loggeas adecuadamente, comprobar si al hacer la insercion de la comunidad pasas el username del usuario logado SI, lo hace

menos mal, algo que te sale para el dia de hoy!

 
 14 de junio
 ahora en ppio tienes el login propio, hace la consulta bien pero no esta redireccionando al inicio del flujo... OK hecho,AHORA SI!!!!
 
Estas intentando traer los datos de los morosos antes de hacer la insercion, pq ahora has puesto unique true en el campo nifcif, si intentas insertar otro,
 salta la excepcion de unicidad, tienes un metodo en morososdao pero no esta haciendo bien el trabajo, esta dando un java.lang.StackOverflowError!
 at java.lang.String.valueOf(String.java:2945)
	at java.lang.Long.toString(Long.java:740)
	at java.lang.String.valueOf(String.java:2826)
	at java.lang.StringBuilder.append(StringBuilder.java:115)
	at com.aironman.core.pojos.ComunidadVecinos.toString(ComunidadVecinos.java:264)
	at sun.reflect.GeneratedMethodAccessor39.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
	at java.lang.reflect.Method.invoke(Method.java:597)
	at org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer.invoke(JavassistLazyInitializer.java:192)
	at com.aironman.core.pojos.ComunidadVecinos_$$_javassist_3.toString(ComunidadVecinos_$$_javassist_3.java)
	at java.lang.String.valueOf(String.java:2826)
	at java.lang.StringBuilder.append(StringBuilder.java:115)
	at com.aironman.core.pojos.ViviendasConDeudas.toString(ViviendasConDeudas.java:201)
	at java.lang.String.valueOf(String.java:2826)
	at java.lang.StringBuilder.append(StringBuilder.java:115)
	
 eso es que me he pasado de los 128 kb del tama�o del heap, o lo aumentas o te lees esto antes:
 
 http://stackoverflow.com/questions/860550/stack-overflows-from-deep-recursion-in-java En principio lo has resuelto aunmentando el tama�o del heap
 y cambiando el metodo toString en los pojos, no has puesto las referencias a los objetos foraneos, de forma que no habra recursion profunda y el pete no
 deberia salir mas!
 
 17 de junio
 
 Para hoy espero tener arreglado el problema de intentar insertar algo que ya existe. Empiezo con los morosos OK
  OJITO, has cambiado en el pojo comunidadvecinos el campo refCatastral para hacerlo unico, AUN no has cambiado en el hibernate.properties la propiedad
  de validate a crete-drop. No veo porque esta ocurriendo la excepcion, se que es por la restriccion de unicidad, que salta cuando intento insertar algo 
  ya existente, que esta ocurriendo cuando busco por el identificador refCatastral que es unique? hasta que no tengas el entorno para el debug no avanzaras nada.
  
entorno debug para junit a�adido

Voy a a a�adir soporte para que no se puedan insertar duplicados en comunidadvecinos. OK. en ppio lo has hecho siguiendo la tecnica de crear un criterion,
asi podre invocar este metodo para saber mediante ajax si la entidad existe en el sistema! 
Tienes que hacer lo mismo para morosos, crear un metodo en el dao para que acepte un criterion OK ahora 

18 de junio
Tienes que hacer que se muestre el pdf generado por el cliente al solicitar la contratacion de jorge. 
Tienes que hacer la consulta necesaria para la pagina de certificados, te bastar� con la consulta que haces para generar el primer certificado, con eso mostraras
un resumen de la informacion que has introducido anteriormente. Una vez tengas eso, la accion de contratar con el despacho debe lanzar las siguientes acciones:

generar el certificado, en pdf, doc y html. El html es el que debes de mostrar al cliente en una pesta�a siguiente. El pdf a lo mejor sobra, y el doc se va
a indexar.

Se va a generar en bd una entidad Demanda, asociada al caso del cliente. DEFINIR mas esto

En la pagina inicial, el usuario con perfil ROLE_USER va a ver el estado de la demanda que ha encargado con el despacho. Va a ver el estado del proceso, 
el abogado que ha contratado, su tlf.

En la pagina inicial, el perfil ROLE_ADMIN, va a ver las demandas que abiertas y tiene la obligacion de asignar un abogado.

Lo mejor seria que tuvieras tres perfiles, ROLE_ABOGADO,ROLE_FINCA,ROLE_ADMIN, uno para cada actor de este teatro, puedo??? yo creo que si!

tienes que conseguir el efecto ajax en las paginas
de comunidades y morosos, programar el evento change... o si eso no te funciona, mira esto:

https://wiki.jasig.org/display/PLT/Techniques+for+integrating+AJAX+within+Spring+Web+Flow+Portlets

quieres hacer que sea el apache web server el que tenga las imagenes estaticas, por ahora las de adelante y retroceder, para ello algo tendras que hacer con 
el siguiente fichero :
/private/etc/apache2/httpd.conf

Ucd dublin buscar sitio para los cursos de ingles ... recomendado por la prima isa




HAs modificado el template para que la consulta tenga en cuenta al user logado para generar el certificado. Tienes que probarlo! OK! funciona
Necesitas poder mostrar el resumen de todo lo anteriormente generado en la pantalla de certificados! OK, FUNCIONA

Ahora necesitas un servlet para cuando haya que mostrar al usuario el documento generado, una tabla con las demandas que tiene contratadas con Jorge, el 
estado de la demanda, etc...

Ahora la accion de contratar con el despacho por parte del cliente administrador de fincas conlleva:
	1) la generacion de la demanda, del papel fisico, el cual guardo para luego tener que mostrar
	2) la creacion de la tupla fisica Demanda en bd
	3) en la pantalla de inicio el usuario con este perfil debera ver un listado con esta informacion, sobre todo debe ver el estado de la demanda, 
	si tiene algun abogado asignado( solo Jorge puede asignar abogado)
	
Para ello, has modificado el CertificadosServiceImpl, para que haga la insercion en la tabla de Demandas.
Ahora una demanda siempre esta asociada al usuario logado con perfil ROLE_FINCAS, por lo que debo preguntar al servicio de usuarios dado el nombre.
Tienes DAOS y servicios para demandas. Tambien tienes un test que te va a servir para encontrarle todos los errores.

19 de junio


cosas para hacer hoy:
	modificar el pojo demandas para que guarde la ruta fisica de donde hay que cargar el documento htlml para el cliente
	Hacer un servicio TareasDespachoService que englobe las acciones que va a realizar el despacho, como contactar 
	
	Al final la ruta fisica donde se ha generado el papel inicial de la demanda lo has puesto en el pojo HistoricoDemandas, por lo que has tenido que crear
	daos, servicios y test para ese pojo, Tienes un DespachoServiceImpl implemnentado, probarlo bien, en ppio ya funciona, tienes que probarlo bien, 
	En ppio has arreglado lo de los morosos, ahora inserta. PROBAR BIEN.
	

 20 DE JUNIO 
 
acuerdate de lanzar esto cada vez que empieces a desarrollar. Esto cuando lo subas a produccion es importantisimo!!!! seguramente seran parametros para lanzar el
tomcat, que no deja de ser un contenedor de servlets


Que pasa cuando intentas modificar un moroso existente? o una comunidad? es decir, introduces los datos de por ejemplo una comunidad, �sta tiene
como atributos unicos la direccion y la referencia catastral, si introduces alguno que ya existe, que haces? como poco avisar! y decirle que debe cambiarlo, 
no hay que dejarle avanzar hasta que introduzca datos nuevos. Para hoy debes tener modificado el servicio de comunidades y la jsp para que no ocurra mas.

Estas con eso, ahora mismo tienes un problema si te encuentras una comunidad o un moroso existente, no se que hacer, has modificado los servicios en la operacion
de creacion, pero no te funciona bien...

24 de junio

Ahora puedes avanzar sobre el flujo sin necesidad de persistir nada, el problema es que la info no se mantiene en las pantallas!!
tengo que setear en el value el campo del pojo?

DEBES CREAR un mapeo adecuado para /invalidSession.htm

Una vez que se generan bien las demandas y el historico, te pondras para mostrar lo necesario al cliente con ROLE_FINCA una vez ha contratado con el despacho
La idea es que el user con ROLE_FINCA vea menos informacion que el user con ROLE_ADMIN, para ello deberas lanzar una consulta del tipo:
SELECT H.RUTAFISICADEMANDA AS URL_CERTIFICADO,
  	   U.USERNAME as usuario,
  	   MOR.nombre as nombre_moroso,
  	   COM.nombrecomunidad as nombre_comunidad,
  	   COM.direccion as direccion_comunidad, 
  	   COM.REFCATASTRAL as referencia_catastral,
  	   D.TIPO AS ESTADO_DEMANDA 
FROM USERS U,
	 JUNTAS_ORDINARIAS JUNTA,
	 COMUNIDADVECINOS COM,
	 VIVIENDASCONDEUDAS VIV,
	 MOROSO MOR,
	 DEMANDAS D,
	 historico_demandas_viviendas H 
WHERE D.IDDEMANDA=H.DEMANDA_IDDEMANDA AND
	  U.USER_ID=COM.USUARIO_USER_ID AND
	  COM.junta_idjunta=JUNTA.idjunta AND
	  COM.idcomunidad=VIV.comunidad_idcomunidad AND
	  MOR.IDMOROSO=VIV.moroso_idmoroso AND
	  D.usuario_user_id=U.USER_ID AND
	  D.iddemanda = H.demanda_iddemanda AND
	  H.deudora_iddeuda=VIV.IDDEUDA AND
	  U.username='alonsoir'
 
 Ahora estas mostrando esto para los clientes de rol finca... son las demandas asociadas al cliente, es decir, un cliente con el rol fincas ha completado
 estas tratando de usar una tabla que me provea paginacion, he modificado index1.jsp y header.jsp asi como a�adido ficheros a WEB-INF/css/, WEB-INF/js
 y WEB-INF/images y no se porque pero el dispatcherServlet no los esta procesando, por lo que chungo, lo suyo es poner todos estos ficheros para que los gestione
 apache web server.
 Tambien debes hacer que lo que debe ver el usuario es el fichero .html que hemos generado!!!! para ello debes hacer un servlet que devuelva este fichero. 
 La libreria jquery que tienes para el table paginado AUN NO CARGA BIEN LOS RECURSOS JS, CSS E IMAGES. Has tenido que comentar en el header las definiciones
 js y css, tambien tienes en el index1.jsp el codigo en ppio necesario para inicializar y usar la tabla.
 
 http://www.jquery4u.com/plugins/30-amazing-jquery-tables/
 
 http://code.google.com/p/jquery-jtps/
 
 http://www.overset.com/2008/08/30/animated-sortable-datagrid-jquery-plugin-jtps/
 
 buscar esto en google:
 
 no mapping found for http request with uri in dispatcherservlet with name css
 
 Tienes esto para tratar los properties, en el applicationContext, el tema es que necesitas dos properties, el hibernate.properties y el necesario
 para los certificados, pues tienes los datos hardcodeados en el servicioCertificados
 
	<bean id="hibernatePropertiesConfigurer"
		class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="location" value="classpath:hibernate.properties" />
	</bean>

AL FINAL Y COMO NECESITAS GESTIONAR EL PROPERTIES DE VIA PROGRAMATICA, HE USADO LA CLASE CertificadosPropertiesConfig y puedo tenerlo inyectado en el
CertificadosServiceImpl... te faltaria poner el resto de campos en ese properties y modificar el CertificadosBean de manera apropiada. DONE!
	
En ppio has mejorado mucho el rendimiento al tener ya preconstruidos la plantilla jasper gracias a @PostConstruct. Quedaria pendiente si pudiera usar la conexion
que necesito usar cada vez que genero el documento... Ahora si,tenias un problema pq se habia colado un espacio en blanco en el properties!!!! arreglado, ahora
se hace un trim antes de asignar los valores leidos al objeto conn. DONE!!!

Tienes que depurar el CertificadosController. Lo vas a hacer con spring-test DONE!!!
 YA TIENES UN SERVLET QUE DEVUELVE LOS PDF GENERADOS PARA QUE EL CLIENTE LOS VEA DONE!!!


2 de julio

Tienes que poder enviar un mail a Jorge cada vez que el cliente pulse el boton de la pantalla de certificados, 
para ello tienes que sacar el modulo de email que hicistes para el proyecto de la tienda virtual. DONE!! incluso
mejorado un poquito pq ahora el user y pass del mail estan en un properties y lo tengo gestionado a la manera de spring.

recuerda, esto siempre antes de empezar a desarrollar y por supuesto que estos valores a produccion.
MAVEN_OPTS="-server -XX:MaxPermSize=512M -ms1024M -mx1024M"
export MAVEN_OPTS

PARA MA�ANA TIENES QUE HACER LO NECESARIO PARA QUE LA PAGINACION FUNCIONE ADECUADAMENTE, 
esta cargando adecuadamente la libreria js? por lo menos carga adecuadamente las imagenes! algo es algo! que esta pasando
con la libreria javascript? si no me funcione, encontrar� un CDN que aloje las librerias js y css necesarias! DONE
esta es la libreria q estas usando, y estas usando el cdn de microsoft
http://www.datatables.net/release-datatables/examples/basic_init/zero_config.html DONE ya hay paginacion, faltaria habilitar la busqueda que proporciona
el plugin

3 de julio


Has habilitado la seguridad por servicios, ahora en ppio solo alguien con el ROL adecuado podr� ejecutar 
esa accion del servicio, tambien tienes una pagina 403 para los forbidden y has mejorado el header para que se muestre
adecuadamente los login o logout 


Ahora jorge quiere tambien que un administrador de fincas pueda consultar y modificar los datos de:

	ComunidadVecinos, Morosos, juntas y fincas morosas! mas madera! PENDIENTE
	
Ademas de la pagina para �l en la que debe asignar un abogado a la demanda. Algo mas? PENDIENTE
jorge quiere que salga tambien la ciudad de la comunidad DONE, tlf movil y fijo del moroso DONE 

tienes que hacer que la refcatastral en comunidadvecinos sea nullable, habra q cambiar el pojo y quitar la validacion
js DONE

tambien tienes que cambiar el formato de los botones imagenes DONE

en los daos has puesto merge() en vez de saveorupdate() en ppio para evitar una excepcion, para arreglarlo, te has basado en esto:
http://www.stevideter.com/2008/12/07/saveorupdate-versus-merge-in-hibernate/ a consecuencia de ello, no se esta propagando bien la fk de junta 
en comunidades, por lo que cuando lanzo la consulta para sacar la informacion del certificado, esta falla pues falta un join! CHECK!!!!!

has refactorizado y quitado de los servicios los throws, en cambio los tienes en los daos, TIENES QUE PASAR TODOS LOS 
TESTS
