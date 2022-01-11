--------------------------------------------------------
--  File created - Salý-Ocak-11-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger TRG_SILME
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."TRG_SILME" 
AFTER DELETE
ON CALISANLAR
FOR EACH ROW
BEGIN
DELETE FROM GIRIS WHERE CALISAN_NO=:OLD.CALISAN_NO;
end;
/
ALTER TRIGGER "SYSTEM"."TRG_SILME" ENABLE;
