-- base de datos congresos poryecto SisCongresos
create database congresos;

-- Crea la tabla congresos
create table Congresos
 (  ClvCon int unsigned not null auto_increment,
    TitCon varchar(125) not null,
    TemaCon varchar(125) not null,
    Sede varchar(125) not null,
    FechaIni date not null,
    FechaFin date not null,
    primary key(ClvCon) );

-- Crea la tabla eventos
create table Eventos
 (  ClvEven int unsigned not null auto_increment,
    TitEven varchar(125) not null,
    TemaEven varchar(125) not null,
    FechaYHora datetime not null,
    TipoEven varchar(125) not null,
    primary key(ClvEven) );

-- Crea la tabla Planea relacion entre Congresos y Eventos
create table Planea
 (  ClvCon int unsigned not null,
    ClvEven int unsigned not null,
    primary key(ClvCon,ClvEven) );

-- Tabla de datos personales (asistentes, exponentes, organizadores)
create table DtsPers
 (  ClvDts int unsigned not null auto_increment,
    Nombre varchar(85) not null,
    Appat varchar(85) not null,
    Apmat varchar(85) not null,
    Dir varchar(45) not null,
    Ciudad varchar(25) not null,
    Estado varchar(25) not null,
    TelCasa varchar(10) not null,
    TelOfic varchar(20) not null,
    TelMovil varchar(10) not null,
    CorreoE varchar(25) not null,
    Titulo varchar(125), -- titulo profesional
    primary key(ClvDts) );

-- Tabla de asistentes relacion entre congresos y dtspers
create table Asistentes
 (  ClvCon int unsigned not null,
    ClvDts int unsigned not null,
    primary key(ClvCon,ClvDts) );

-- Tabla de asistentes por evento relacion entre eventos y dtspers
create table AsisEven
 (  ClvEven int unsigned not null,
    ClvDts int unsigned not null,
    asis boolean not null,
    primary key(ClvEven,ClvDts) );

-- Tabla de personal relacion entre congresos y dtspers
create table Personal
 (  ClvCon int unsigned not null,
    ClvDts int unsigned not null,
    CrgFun varchar(255) not null,
    activs varchar(255) not null,
    primary key(ClvCon,ClvDts) );

-- Tabla de datos de trabajos de exponentes
create table Exponentes
 (  ClvExp int unsigned not null auto_increment,
    TitTrab varchar(125) not null,
    CatTrab varchar(125) not null,
    TipoTrab varchar(125) not null,
    Individual boolean not null,
    eConv varchar(25),
    eOfic varchar(25),
    eMail varchar(25),
    FchaRec date,
    FchaAcep date,
    ConfAsis boolean,
    AcRec varchar(125),
    ubEnMem varchar(125),
    ubEnInst varchar(125),
    obser varchar(255),
    primary key(ClvExp) );

-- Tabla Participan relacion entre congresos y exponentes
create table Participan
 (  ClvCon int unsigned not null,
    ClvExp int unsigned not null,
    primary key(clvCon,ClvExp) );

-- Tabla ExpTiene relacion entre exponentes y datos personales
create table ExpTiene
 (  ClvDts int unsigned not null,
    ClvExp int unsigned not null );
    
-- Tabla ExpEve relacion entre exponentes y eventos
create table ExpEve
 (  ClvEven int unsigned not null,
    ClvExp int unsigned not null,
    primary key(ClvEven,ClvExp) );