--------------------------------------------------------
--  File created - Salý-Ocak-11-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger TRG_PUAN
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."TRG_PUAN" 
AFTER INSERT
ON SATISLAR
FOR EACH ROW
BEGIN
UPDATE MUSTERILER SET TOPLAM_PUAN = (TOPLAM_PUAN+1) 
WHERE MUSTERI_CARD_NO=:NEW.MUSTERI_CARD_NO;
end;
/
ALTER TRIGGER "SYSTEM"."TRG_PUAN" ENABLE;
