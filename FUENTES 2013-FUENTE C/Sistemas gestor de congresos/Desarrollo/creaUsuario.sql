-- SISCONGREGOS Creacion de usuario y permisos para aceptar la conexion del
--   sistema y uso de la base de datos (usuario=usCon password=pssCon)
grant execute, insert, delete, select, update on congresos.* to 'usCon'@'%' identified by 'pssCon';
