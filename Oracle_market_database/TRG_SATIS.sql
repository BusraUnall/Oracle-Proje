--------------------------------------------------------
--  File created - Salý-Ocak-11-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger TRG_SATIS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."TRG_SATIS" 
AFTER INSERT
ON SATISLAR
FOR EACH ROW
BEGIN
UPDATE STOKLAR SET URUN_SAYISI = (URUN_SAYISI-1) 
WHERE URUN_NO=:NEW.URUN_NO;
END;
/
ALTER TRIGGER "SYSTEM"."TRG_SATIS" ENABLE;
