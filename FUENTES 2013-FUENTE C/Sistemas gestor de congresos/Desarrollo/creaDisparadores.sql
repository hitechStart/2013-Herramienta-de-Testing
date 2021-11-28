-- Trigger que al agregar un asistente a un congreso crea los registros de
 -- asistencia correspondientes en la tabla asiseven
create trigger nuevaAsis after insert
  on Asistentes for each row
  begin
    declare hecho int default 0;
    declare claveeve int;
    declare crsrEves cursor for select ClvEven from Planea
      where Planea.ClvCon = NEW.ClvCon;
    declare continue handler for sqlstate '02000' set hecho = 1;
    open crsrEves;
    repeat
      fetch crsrEves into claveeve;
      if not hecho then
        insert AsisEven values(claveeve,new.ClvDts,0);
      end if;
    until hecho
    end repeat;
    close crsrEves;
  end;

-- Trigger que al borrar una asistencia borra las correspondientes en asiseven
create trigger eliminaAsis after delete
  on Asistentes for each row
  begin
    declare hecho int default 0;
    declare claveeve int;
    declare crsrEves cursor for select ClvEven from Planea
      where Planea.ClvCon = OLD.ClvCon;
    declare continue handler for sqlstate '02000' set hecho = 1;
    open crsrEves;
    repeat
      fetch crsrEves into claveeve;
      if not hecho then
        delete from AsisEven where clveven=claveeve and clvdts=OLD.clvdts;
      end if;
    until hecho
    end repeat;
    close crsrEves;
  end;

-- Trigger que al agregar un evento a un congreso crea los registros de
 -- asistencia correspondientes en la tabla asiseven
create trigger nuevoPlanea after insert
  on Planea for each row
  begin
    declare hecho int default 0;
    declare clavedts int;
    declare crsrDts cursor for select Clvdts from Asistentes
      where Asistentes.ClvCon = NEW.ClvCon;
    declare continue handler for sqlstate '02000' set hecho = 1;
    open crsrDts;
    repeat
      fetch crsrDts into clavedts;
      if not hecho then
        insert AsisEven values(NEW.clvEven,clavedts,0);
      end if;
    until hecho
    end repeat;
    close crsrDts;
  end;
  
  -- Trigger que al borrar un evento borra las correspondientes en asiseven
create trigger eliminaPlanea after delete
  on Planea for each row
  begin
    declare hecho int default 0;
    declare clavedts int;
    declare crsrDts cursor for select Clvdts from Asistentes
      where Asistentes.ClvCon = OLD.ClvCon;
    declare continue handler for sqlstate '02000' set hecho = 1;
    open crsrDts;
    repeat
      fetch crsrDts into clavedts;
      if not hecho then
        delete from AsisEven where clveven=OLD.clveven and clvdts=clavedts;
      end if;
    until hecho
    end repeat;
    close crsrDts;
  end;

