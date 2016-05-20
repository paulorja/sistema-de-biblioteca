--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: exemplar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE exemplar (
    codigo integer NOT NULL,
    codigolivro integer,
    codmatricula integer
);


ALTER TABLE exemplar OWNER TO postgres;

--
-- Name: exemplar_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE exemplar_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE exemplar_codigo_seq OWNER TO postgres;

--
-- Name: exemplar_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE exemplar_codigo_seq OWNED BY exemplar.codigo;


--
-- Name: livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE livro (
    codigo integer NOT NULL,
    titulo character(100),
    autor character(100)
);


ALTER TABLE livro OWNER TO postgres;

--
-- Name: livro_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE livro_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE livro_codigo_seq OWNER TO postgres;

--
-- Name: livro_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE livro_codigo_seq OWNED BY livro.codigo;


--
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pessoa (
    matricula integer NOT NULL,
    tipo character(1),
    name character(100)
);


ALTER TABLE pessoa OWNER TO postgres;

--
-- Name: pessoa_matricula_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pessoa_matricula_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pessoa_matricula_seq OWNER TO postgres;

--
-- Name: pessoa_matricula_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pessoa_matricula_seq OWNED BY pessoa.matricula;


--
-- Name: codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exemplar ALTER COLUMN codigo SET DEFAULT nextval('exemplar_codigo_seq'::regclass);


--
-- Name: codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livro ALTER COLUMN codigo SET DEFAULT nextval('livro_codigo_seq'::regclass);


--
-- Name: matricula; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa ALTER COLUMN matricula SET DEFAULT nextval('pessoa_matricula_seq'::regclass);


--
-- Data for Name: exemplar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY exemplar (codigo, codigolivro, codmatricula) FROM stdin;
\.


--
-- Name: exemplar_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('exemplar_codigo_seq', 1, false);


--
-- Data for Name: livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY livro (codigo, titulo, autor) FROM stdin;
\.


--
-- Name: livro_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('livro_codigo_seq', 1, false);


--
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pessoa (matricula, tipo, name) FROM stdin;
\.


--
-- Name: pessoa_matricula_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pessoa_matricula_seq', 1, false);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

