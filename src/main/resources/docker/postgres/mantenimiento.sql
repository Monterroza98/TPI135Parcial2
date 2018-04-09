-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.2
-- PostgreSQL version: 9.5
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: mantenimiento | type: DATABASE --
-- -- DROP DATABASE IF EXISTS mantenimiento;
-- CREATE DATABASE mantenimiento
-- ;
-- -- ddl-end --
-- 

-- object: public.sub_tipo_mantenimiento | type: TABLE --
-- DROP TABLE IF EXISTS public.sub_tipo_mantenimiento CASCADE;
CREATE TABLE public.sub_tipo_mantenimiento(
	id_sub_tipo_mantenimiento serial NOT NULL,
	nombre character varying(50) NOT NULL,
	descripcion text,
	CONSTRAINT pk_sub_tipo_mantenimiento PRIMARY KEY (id_sub_tipo_mantenimiento)

);
-- ddl-end --

-- object: public.tipo_mantenimiento | type: TABLE --
-- DROP TABLE IF EXISTS public.tipo_mantenimiento CASCADE;
CREATE TABLE public.tipo_mantenimiento(
	id_tipo_mantenimiento serial NOT NULL,
	nombre character varying(60) NOT NULL,
	descipcion text,
	activo boolean,
	id_sub_tipo_mantenimiento integer,
	CONSTRAINT pk_tipo_mantenimiento PRIMARY KEY (id_tipo_mantenimiento)

);
-- ddl-end --

-- object: public.unidad | type: TABLE --
-- DROP TABLE IF EXISTS public.unidad CASCADE;
CREATE TABLE public.unidad(
	id_unidad serial NOT NULL,
	nombre character varying(50) NOT NULL,
	codigo character varying,
	CONSTRAINT pk_unidad PRIMARY KEY (id_unidad)

);
-- ddl-end --

-- object: public.calendario_excepcion | type: TABLE --
-- DROP TABLE IF EXISTS public.calendario_excepcion CASCADE;
CREATE TABLE public.calendario_excepcion(
	id_excepcion serial NOT NULL,
	fecha date NOT NULL,
	estado boolean,
	descripcion text,
	CONSTRAINT pk_calendario_excepcion PRIMARY KEY (id_excepcion)

);
-- ddl-end --

-- object: public.solicitud | type: TABLE --
-- DROP TABLE IF EXISTS public.solicitud CASCADE;
CREATE TABLE public.solicitud(
	id_solicitud serial NOT NULL,
	solicitante character varying(255),
	fecha_solicitud date,
	activo boolean,
	CONSTRAINT pk_solicitud PRIMARY KEY (id_solicitud)

);
-- ddl-end --

-- object: public.prioridad | type: TABLE --
-- DROP TABLE IF EXISTS public.prioridad CASCADE;
CREATE TABLE public.prioridad(
	id_prioridad serial NOT NULL,
	nombre character varying(50) NOT NULL,
	descripcion text,
	activo boolean,
	CONSTRAINT pk_prioridad PRIMARY KEY (id_prioridad)

);
-- ddl-end --

-- object: public.orden_trabajo | type: TABLE --
-- DROP TABLE IF EXISTS public.orden_trabajo CASCADE;
CREATE TABLE public.orden_trabajo(
	id_orden_trabajo bigserial NOT NULL,
	fecha_inicio date,
	observaciones text,
	fecha_estimada date,
	id_solicitud integer,
	id_tipo_mantenimiento integer,
	id_unidad integer,
	id_prioridad integer,
	id_equipo integer,
	CONSTRAINT pk_orden_trabajo PRIMARY KEY (id_orden_trabajo)

);
-- ddl-end --

-- object: public.equipo | type: TABLE --
-- DROP TABLE IF EXISTS public.equipo CASCADE;
CREATE TABLE public.equipo(
	id_equipo serial NOT NULL,
	correlativo character varying(20) NOT NULL,
	observaciones text,
	CONSTRAINT pk_equipo PRIMARY KEY (id_equipo)

);
-- ddl-end --

-- object: public.mantenimiento_detalle | type: TABLE --
-- DROP TABLE IF EXISTS public.mantenimiento_detalle CASCADE;
CREATE TABLE public.mantenimiento_detalle(
	id_mantenimiento_detalle bigserial NOT NULL,
	id_equipo_detalle integer,
	id_oden_trabajo integer,
	CONSTRAINT pk_mantenimiento_detalle PRIMARY KEY (id_mantenimiento_detalle)

);
-- ddl-end --

-- object: public.equipo_detalle | type: TABLE --
-- DROP TABLE IF EXISTS public.equipo_detalle CASCADE;
CREATE TABLE public.equipo_detalle(
	id_equipo_detalle bigserial NOT NULL,
	id_parte integer,
	id_modelo integer,
	id_equipo integer,
	id_marca integer,
	CONSTRAINT pk_equipo_detalle PRIMARY KEY (id_equipo_detalle)

);
-- ddl-end --

-- object: public.marca | type: TABLE --
-- DROP TABLE IF EXISTS public.marca CASCADE;
CREATE TABLE public.marca(
	id_marca serial NOT NULL,
	nombre character varying(50),
	activo boolean,
	descripcion text,
	CONSTRAINT pk_marca PRIMARY KEY (id_marca)

);
-- ddl-end --

-- object: public.modelo | type: TABLE --
-- DROP TABLE IF EXISTS public.modelo CASCADE;
CREATE TABLE public.modelo(
	id_modelo serial NOT NULL,
	nombre character varying(50) NOT NULL,
	activo boolean,
	descripcion text,
	CONSTRAINT pk_modelo PRIMARY KEY (id_modelo)

);
-- ddl-end --

-- object: public.estado | type: TABLE --
-- DROP TABLE IF EXISTS public.estado CASCADE;
CREATE TABLE public.estado(
	id_estado serial NOT NULL,
	nombre character varying(50) NOT NULL,
	activo boolean,
	descripcion text,
	CONSTRAINT pk_estado PRIMARY KEY (id_estado)

);
-- ddl-end --

-- object: public.tipo_responsable | type: TABLE --
-- DROP TABLE IF EXISTS public.tipo_responsable CASCADE;
CREATE TABLE public.tipo_responsable(
	id_tipo_responsable serial NOT NULL,
	nombre character varying(50),
	descripciont text,
	CONSTRAINT pk_tipo_responsable PRIMARY KEY (id_tipo_responsable)

);
-- ddl-end --

-- object: public.responsable | type: TABLE --
-- DROP TABLE IF EXISTS public.responsable CASCADE;
CREATE TABLE public.responsable(
	id_responsable serial NOT NULL,
	nombre character varying(50),
	activo boolean,
	descripcion text,
	id_tipo_responsable integer,
	CONSTRAINT pk_rsponsable PRIMARY KEY (id_responsable)

);
-- ddl-end --

-- object: public.estado_mantenimiento_detalle | type: TABLE --
-- DROP TABLE IF EXISTS public.estado_mantenimiento_detalle CASCADE;
CREATE TABLE public.estado_mantenimiento_detalle(
	id_estado_mantenimiento_detalle serial NOT NULL,
	id_mantenimiento_detalle integer,
	id_estado integer,
	id_responsable integer,
	id_paso integer,
	CONSTRAINT pk_estado_mantenimiento_detalle PRIMARY KEY (id_estado_mantenimiento_detalle)

);
-- ddl-end --

-- object: public.diagnostico | type: TABLE --
-- DROP TABLE IF EXISTS public.diagnostico CASCADE;
CREATE TABLE public.diagnostico(
	id_diagnostico serial NOT NULL,
	nombre character varying(50) NOT NULL,
	descripcion text,
	CONSTRAINT pk_diagnostico PRIMARY KEY (id_diagnostico)

);
-- ddl-end --

-- object: public.procedimiento | type: TABLE --
-- DROP TABLE IF EXISTS public.procedimiento CASCADE;
CREATE TABLE public.procedimiento(
	id_procedimiento serial NOT NULL,
	nombre character varying(50) NOT NULL,
	activo boolean,
	descripcion text,
	id_diagnostico integer,
	CONSTRAINT pk_procedimiento PRIMARY KEY (id_procedimiento)

);
-- ddl-end --

-- object: public.paso | type: TABLE --
-- DROP TABLE IF EXISTS public.paso CASCADE;
CREATE TABLE public.paso(
	id_paso serial NOT NULL,
	nombre character varying(50) NOT NULL,
	descripcion text,
	id_procedimiento integer,
	CONSTRAINT pk_paso PRIMARY KEY (id_paso)

);
-- ddl-end --

-- object: public.tipo_parte | type: TABLE --
-- DROP TABLE IF EXISTS public.tipo_parte CASCADE;
CREATE TABLE public.tipo_parte(
	id_tipo_parte serial NOT NULL,
	nombre character varying(50) NOT NULL,
	descripcion text,
	CONSTRAINT pk_tipo_parte PRIMARY KEY (id_tipo_parte)

);
-- ddl-end --

-- object: public.parte | type: TABLE --
-- DROP TABLE IF EXISTS public.parte CASCADE;
CREATE TABLE public.parte(
	id_parte serial NOT NULL,
	nombre character varying(50) NOT NULL,
	descripcion text,
	id_tipo_parte integer,
	CONSTRAINT pk_parte PRIMARY KEY (id_parte)

);
-- ddl-end --

-- object: public.diagnostico_parte | type: TABLE --
-- DROP TABLE IF EXISTS public.diagnostico_parte CASCADE;
CREATE TABLE public.diagnostico_parte(
	id_diagnostico_parte serial NOT NULL,
	id_diagnostico integer,
	id_parte integer,
	CONSTRAINT pk_diagnostico_parte PRIMARY KEY (id_diagnostico_parte)

);
-- ddl-end --

-- object: public.calendario | type: TABLE --
-- DROP TABLE IF EXISTS public.calendario CASCADE;
CREATE TABLE public.calendario(
	id_fecha serial NOT NULL,
	fecha date,
	descripcion text,
	CONSTRAINT pk_calendario PRIMARY KEY (id_fecha)

);
-- ddl-end --

-- object: public.orden_trabajo_calendario | type: TABLE --
-- DROP TABLE IF EXISTS public.orden_trabajo_calendario CASCADE;
CREATE TABLE public.orden_trabajo_calendario(
	id_fecha integer,
	id_orden_trabajo integer,

);
-- ddl-end --

-- object: fk_tipo_mantenimiento_sub_tipo_mantenimiento | type: CONSTRAINT --
-- ALTER TABLE public.tipo_mantenimiento DROP CONSTRAINT IF EXISTS fk_tipo_mantenimiento_sub_tipo_mantenimiento CASCADE;
ALTER TABLE public.tipo_mantenimiento ADD CONSTRAINT fk_tipo_mantenimiento_sub_tipo_mantenimiento FOREIGN KEY (id_sub_tipo_mantenimiento)
REFERENCES public.sub_tipo_mantenimiento (id_sub_tipo_mantenimiento) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_orden_trabajo_tipo_mantenimiento | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo DROP CONSTRAINT IF EXISTS fk_orden_trabajo_tipo_mantenimiento CASCADE;
ALTER TABLE public.orden_trabajo ADD CONSTRAINT fk_orden_trabajo_tipo_mantenimiento FOREIGN KEY (id_tipo_mantenimiento)
REFERENCES public.tipo_mantenimiento (id_tipo_mantenimiento) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_orden_trabajo_unidad | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo DROP CONSTRAINT IF EXISTS fk_orden_trabajo_unidad CASCADE;
ALTER TABLE public.orden_trabajo ADD CONSTRAINT fk_orden_trabajo_unidad FOREIGN KEY (id_unidad)
REFERENCES public.unidad (id_unidad) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_orden_trabajo_solicitud | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo DROP CONSTRAINT IF EXISTS fk_orden_trabajo_solicitud CASCADE;
ALTER TABLE public.orden_trabajo ADD CONSTRAINT fk_orden_trabajo_solicitud FOREIGN KEY (id_solicitud)
REFERENCES public.solicitud (id_solicitud) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_orden_trabajo_prioridad | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo DROP CONSTRAINT IF EXISTS fk_orden_trabajo_prioridad CASCADE;
ALTER TABLE public.orden_trabajo ADD CONSTRAINT fk_orden_trabajo_prioridad FOREIGN KEY (id_prioridad)
REFERENCES public.prioridad (id_prioridad) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_orden_trabajo_equipo | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo DROP CONSTRAINT IF EXISTS fk_orden_trabajo_equipo CASCADE;
ALTER TABLE public.orden_trabajo ADD CONSTRAINT fk_orden_trabajo_equipo FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_mantenimiento_detalle_orden_trabajo | type: CONSTRAINT --
-- ALTER TABLE public.mantenimiento_detalle DROP CONSTRAINT IF EXISTS fk_mantenimiento_detalle_orden_trabajo CASCADE;
ALTER TABLE public.mantenimiento_detalle ADD CONSTRAINT fk_mantenimiento_detalle_orden_trabajo FOREIGN KEY (id_oden_trabajo)
REFERENCES public.orden_trabajo (id_orden_trabajo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_equipo_detalle_equipo | type: CONSTRAINT --
-- ALTER TABLE public.equipo_detalle DROP CONSTRAINT IF EXISTS fk_equipo_detalle_equipo CASCADE;
ALTER TABLE public.equipo_detalle ADD CONSTRAINT fk_equipo_detalle_equipo FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_equipo_detalle_modelo | type: CONSTRAINT --
-- ALTER TABLE public.equipo_detalle DROP CONSTRAINT IF EXISTS fk_equipo_detalle_modelo CASCADE;
ALTER TABLE public.equipo_detalle ADD CONSTRAINT fk_equipo_detalle_modelo FOREIGN KEY (id_modelo)
REFERENCES public.modelo (id_modelo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_equipo_detalle_marca | type: CONSTRAINT --
-- ALTER TABLE public.equipo_detalle DROP CONSTRAINT IF EXISTS fk_equipo_detalle_marca CASCADE;
ALTER TABLE public.equipo_detalle ADD CONSTRAINT fk_equipo_detalle_marca FOREIGN KEY (id_marca)
REFERENCES public.marca (id_marca) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_responsable_tipo_responsable | type: CONSTRAINT --
-- ALTER TABLE public.responsable DROP CONSTRAINT IF EXISTS fk_responsable_tipo_responsable CASCADE;
ALTER TABLE public.responsable ADD CONSTRAINT fk_responsable_tipo_responsable FOREIGN KEY (id_tipo_responsable)
REFERENCES public.tipo_responsable (id_tipo_responsable) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_estado_mantenimiento_detalle_mantenimiento_detalle | type: CONSTRAINT --
-- ALTER TABLE public.estado_mantenimiento_detalle DROP CONSTRAINT IF EXISTS fk_estado_mantenimiento_detalle_mantenimiento_detalle CASCADE;
ALTER TABLE public.estado_mantenimiento_detalle ADD CONSTRAINT fk_estado_mantenimiento_detalle_mantenimiento_detalle FOREIGN KEY (id_mantenimiento_detalle)
REFERENCES public.mantenimiento_detalle (id_mantenimiento_detalle) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_estado_mantenimiento_detalle_estado | type: CONSTRAINT --
-- ALTER TABLE public.estado_mantenimiento_detalle DROP CONSTRAINT IF EXISTS fk_estado_mantenimiento_detalle_estado CASCADE;
ALTER TABLE public.estado_mantenimiento_detalle ADD CONSTRAINT fk_estado_mantenimiento_detalle_estado FOREIGN KEY (id_estado)
REFERENCES public.estado (id_estado) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_estado_mantenimiento_detalle_responsable | type: CONSTRAINT --
-- ALTER TABLE public.estado_mantenimiento_detalle DROP CONSTRAINT IF EXISTS fk_estado_mantenimiento_detalle_responsable CASCADE;
ALTER TABLE public.estado_mantenimiento_detalle ADD CONSTRAINT fk_estado_mantenimiento_detalle_responsable FOREIGN KEY (id_responsable)
REFERENCES public.responsable (id_responsable) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_procedimiento_diagnostico | type: CONSTRAINT --
-- ALTER TABLE public.procedimiento DROP CONSTRAINT IF EXISTS fk_procedimiento_diagnostico CASCADE;
ALTER TABLE public.procedimiento ADD CONSTRAINT fk_procedimiento_diagnostico FOREIGN KEY (id_diagnostico)
REFERENCES public.diagnostico (id_diagnostico) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_paso_procedimiento | type: CONSTRAINT --
-- ALTER TABLE public.paso DROP CONSTRAINT IF EXISTS fk_paso_procedimiento CASCADE;
ALTER TABLE public.paso ADD CONSTRAINT fk_paso_procedimiento FOREIGN KEY (id_procedimiento)
REFERENCES public.procedimiento (id_procedimiento) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_parte_tipo_parte | type: CONSTRAINT --
-- ALTER TABLE public.parte DROP CONSTRAINT IF EXISTS fk_parte_tipo_parte CASCADE;
ALTER TABLE public.parte ADD CONSTRAINT fk_parte_tipo_parte FOREIGN KEY (id_tipo_parte)
REFERENCES public.tipo_parte (id_tipo_parte) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_diagnostico_parte_parte | type: CONSTRAINT --
-- ALTER TABLE public.diagnostico_parte DROP CONSTRAINT IF EXISTS fk_diagnostico_parte_parte CASCADE;
ALTER TABLE public.diagnostico_parte ADD CONSTRAINT fk_diagnostico_parte_parte FOREIGN KEY (id_parte)
REFERENCES public.parte (id_parte) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_diagnostico_parte_diagnostico | type: CONSTRAINT --
-- ALTER TABLE public.diagnostico_parte DROP CONSTRAINT IF EXISTS fk_diagnostico_parte_diagnostico CASCADE;
ALTER TABLE public.diagnostico_parte ADD CONSTRAINT fk_diagnostico_parte_diagnostico FOREIGN KEY (id_diagnostico)
REFERENCES public.diagnostico (id_diagnostico) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_orden_trabajo_calendario_calendario | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo_calendario DROP CONSTRAINT IF EXISTS fk_orden_trabajo_calendario_calendario CASCADE;
ALTER TABLE public.orden_trabajo_calendario ADD CONSTRAINT fk_orden_trabajo_calendario_calendario FOREIGN KEY (id_fecha)
REFERENCES public.calendario (id_fecha) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_orden_trabajo_calendario_orden_trabajo | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo_calendario DROP CONSTRAINT IF EXISTS fk_orden_trabajo_calendario_orden_trabajo CASCADE;
ALTER TABLE public.orden_trabajo_calendario ADD CONSTRAINT fk_orden_trabajo_calendario_orden_trabajo FOREIGN KEY (id_orden_trabajo)
REFERENCES public.orden_trabajo (id_orden_trabajo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --


