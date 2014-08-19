CREATE TABLE "IsisAuditEntry"
(
    "id" SERIAL,
    "memberIdentifier" varchar(255) NULL,
    "postValue" varchar(255) NULL,
    "preValue" varchar(255) NULL,
    "propertyId" varchar(50) NULL,
    "targetClass" varchar(50) NULL,
    "target" varchar(2000) NOT NULL,
    "timestamp" timestamptz NOT NULL,
    "transactionId" varchar(36) NOT NULL,
    "user" varchar(50) NOT NULL,
    CONSTRAINT "IsisAuditEntry_PK" PRIMARY KEY ("id")
)