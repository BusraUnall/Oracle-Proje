--------------------------------------------------------
--  File created - Salý-Ocak-11-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure PRC_TOPLAM
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYSTEM"."PRC_TOPLAM" 
(
  G_NO IN NUMBER 
, P_URUN_SAYISI OUT NUMBER 
) AS 
BEGIN
  SELECT COUNT(grup_no) INTO P_URUN_SAYISI FROM URUNLER GROUP BY grup_no HAVING grup_no=G_NO;
  END;

/
