--------------------------------------------------------
--  File created - Sal�-Ocak-11-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MUSTERILER
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."MUSTERILER" 
   (	"MUSTERI_CARD_NO" VARCHAR2(12 BYTE), 
	"ISIM" VARCHAR2(20 BYTE), 
	"SOYISIM" VARCHAR2(20 BYTE), 
	"ADRES" VARCHAR2(60 BYTE), 
	"TELEFON" VARCHAR2(12 BYTE), 
	"CINSIYET" VARCHAR2(5 BYTE), 
	"KART_ALIM_TARIHI" DATE, 
	"TOPLAM_PUAN" NUMBER(7,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.MUSTERILER
SET DEFINE OFF;
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('L7773','P�nar','Ser','Alpaslan,21, 42310, Ere�li/Istanbul, Turkey','05179701246','K',to_date('15/04/2018','DD/MM/RRRR'),'15');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('B5334','Mira�','Karakoyun','�aylar,31, 78502, Ovacik/Istanbul, Turkey','05095957513','E',to_date('25/12/2019','DD/MM/RRRR'),'5');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('S7499','Ahmet Burak','K�z�lca','Bahatlar K�y�,5, 43702, Emet/Istanbul, Turkey','05899797607','E',to_date('03/01/2022','DD/MM/RRRR'),'0');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('B5121','�brahim','Orhan','Sabunlu,25, 48770, Dalaman/Istanbul, Turkey','05422065173','E',to_date('06/01/2022','DD/MM/RRRR'),'2');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('P8435','G�l�in','Ni�anc�','Soysalli,1, 1922, Ceyhan/Istanbul, Turkey','05181316881','K',to_date('03/01/2022','DD/MM/RRRR'),'0');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('K3612','Havva','Bilgili','Kayaba�i K�y�,9, 29100, Merkez/Bursa, Turkey','05427877359','K',to_date('01/08/2020','DD/MM/RRRR'),'6');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('I4389','Mahmut Esat','�mre','�nkaya,18, 21900, Kulp/Tekirdag, Turkey','05413758657','E',to_date('12/07/2020','DD/MM/RRRR'),'1');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('A2776','Sel�uk','Kuruo�lu','Kuz,18, 57902, T�rkeli/Tekirdag, Turkey','05939868934','E',to_date('09/02/2021','DD/MM/RRRR'),'7');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('S7223','Sezai','Boran','Yeni,34, 18280, Kizilirmak/Istanbul, Turkey','05158872601','E',to_date('27/10/2021','DD/MM/RRRR'),'10');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('D5695','Do�ukan','�ahbazo�lu','U�ur Mumcu,13, 6370, Yenimahalle/Istanbul, Turkey','05966749987','E',to_date('24/04/2021','DD/MM/RRRR'),'3');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('F2358','Esin Seren','Suvari','Gedikler,11, 67672, G�k�ebey/Istanbul, Turkey','05512607231','K',to_date('10/03/2021','DD/MM/RRRR'),'11');
Insert into SYSTEM.MUSTERILER (MUSTERI_CARD_NO,ISIM,SOYISIM,ADRES,TELEFON,CINSIYET,KART_ALIM_TARIHI,TOPLAM_PUAN) values ('T5209','Nurdan','G�m��dere','�rnek K�y�,5, 53340, Pazar/Istanbul, Turkey','05960768619','K',to_date('17/12/2021','DD/MM/RRRR'),'21');
--------------------------------------------------------
--  DDL for Index MUSTERILER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."MUSTERILER_PK" ON "SYSTEM"."MUSTERILER" ("MUSTERI_CARD_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table MUSTERILER
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."MUSTERILER" MODIFY ("TOPLAM_PUAN" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MUSTERILER" MODIFY ("MUSTERI_CARD_NO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MUSTERILER" MODIFY ("ISIM" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MUSTERILER" MODIFY ("SOYISIM" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MUSTERILER" MODIFY ("ADRES" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MUSTERILER" MODIFY ("TELEFON" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MUSTERILER" MODIFY ("CINSIYET" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MUSTERILER" MODIFY ("KART_ALIM_TARIHI" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MUSTERILER" ADD CONSTRAINT "MUSTERILER_PK" PRIMARY KEY ("MUSTERI_CARD_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
