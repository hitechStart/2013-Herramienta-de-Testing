-- procedimiento para alta de nuevo congreso
create procedure nuevoCongreso(in tit varchar(125), tema varchar(125), sede varchar(125),
  fini date, ffin date, out clave int)
begin
  declare bandera boolean default true;
  declare auxInt int;
  start transaction;
  insert congresos values(DEFAULT,tit,tema,sede,fini,ffin);
  select row_count() into auxInt;
  if auxInt<>1 then
    set bandera=false;
    set clave=0;
   else
    select last_insert_id() into clave;
  end if;
  if bandera then
    commit;
   else
    rollback;
  end if;
end

-- procedimiento para alta de nuevo en DtsPers
create procedure nuevoDtsPers(in Nom varchar(85), App varchar(85), Apm varchar(85), Dir varchar(45), Cdd varchar(25), 
  Edo varchar(25), TlC varchar(10), TlO varchar(20), TlM varchar(10), CrE varchar(25), Tit varchar(125), out clave int)
begin
  declare bandera boolean default true;
  declare auxInt int;
  start transaction;
  insert DtsPers values(DEFAULT,Nom,App,Apm,Dir,Cdd,Edo,TlC,TlO,TlM,CrE,Tit);
  select row_count() into auxInt;
  if auxInt<>1 then
    set bandera=false;
    set clave=0;
   else
    select last_insert_id() into clave;
  end if;
  if bandera then
    commit;
   else
    rollback;
  end if;
end

-- procedimiento para alta de nuevo en DtsPers
create procedure nuevoEvento(in tit varchar(125), tema varchar(125), fyh varchar(19), tpe varchar(125), out clave int)
begin
  declare bandera boolean default true;
  declare auxInt int;
  start transaction;
  insert Eventos values(DEFAULT,tit,tema,fyh,tpe);
  select row_count() into auxInt;
  if auxInt<>1 then
    set bandera=false;
    set clave=0;
   else
    select last_insert_id() into clave;
  end if;
  if bandera then
    commit;
   else
    rollback;
  end if;
end

-- procedimiento para alta de nuevo en Exponentes
create procedure nuevoExponente(in tit varchar(125), ctr varchar(125), ttr varchar(125), ind boolean,
  eco varchar(25), eof varchar(25), crr varchar(25), frc date, fac date, cna boolean, arc varchar(125),
  ubm varchar(125), ubi varchar(125), obs varchar(255), out clave int)
begin
  declare bandera boolean default true;
  declare auxInt int;
  start transaction;
  insert Exponentes values(DEFAULT,tit,ctr,ttr,ind,eco,eof,crr,frc,fac,cna,arc,ubm,ubi,obs);
  select row_count() into auxInt;
  if auxInt<>1 then
    set bandera=false;
    set clave=0;
   else
    select last_insert_id() into clave;
  end if;
  if bandera then
    commit;
   else
    rollback;
  end if;
end
