--------------------------------------------------------
--  File created - Sal�-Ocak-11-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table GIRIS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."GIRIS" 
   (	"CALISAN_NO" NUMBER(4,0), 
	"GOREV" VARCHAR2(30 BYTE), 
	"SIFRE" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index GIRIS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."GIRIS_PK" ON "SYSTEM"."GIRIS" ("CALISAN_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table GIRIS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."GIRIS" MODIFY ("CALISAN_NO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."GIRIS" MODIFY ("GOREV" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."GIRIS" ADD CONSTRAINT "GIRIS_PK" PRIMARY KEY ("CALISAN_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
