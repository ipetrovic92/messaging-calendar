--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-09-26 04:25:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 206 (class 1259 OID 17499)
-- Name: dezurstva_profesora; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dezurstva_profesora (
    predmet_akronim character varying(255) NOT NULL,
    rok_id bigint NOT NULL,
    profesor_id bigint NOT NULL
);


ALTER TABLE public.dezurstva_profesora OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 17416)
-- Name: korisnik_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.korisnik_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.korisnik_id_sequence OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 17424)
-- Name: korisnik; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.korisnik (
    korisnik_id bigint DEFAULT nextval('public.korisnik_id_sequence'::regclass) NOT NULL,
    korisnicko_ime character varying(255) NOT NULL,
    lozinka character varying(255) NOT NULL,
    rola_id bigint NOT NULL
);


ALTER TABLE public.korisnik OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17551)
-- Name: moguce_prijave_student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.moguce_prijave_student (
    predmet_akronim character varying(255) NOT NULL,
    rok_id bigint NOT NULL,
    broj_indeksa_studenta character varying(255) NOT NULL,
    ocena bigint
);


ALTER TABLE public.moguce_prijave_student OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 17532)
-- Name: moguce_prijave_studentska_sluzba; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.moguce_prijave_studentska_sluzba (
    predmet_akronim character varying(255) NOT NULL,
    rok_id bigint NOT NULL,
    broj_indeksa_studenta character(255) NOT NULL,
    cena_prijave bigint DEFAULT 0,
    status_prijave character varying(255)
);


ALTER TABLE public.moguce_prijave_studentska_sluzba OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 17438)
-- Name: predmet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.predmet (
    akronim_predmeta character varying(255) NOT NULL,
    naziv_predmeta character varying(255) NOT NULL,
    tip_predmeta character varying(255) NOT NULL,
    godina_studija character varying(255) NOT NULL
);


ALTER TABLE public.predmet OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 17741)
-- Name: predmet_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.predmet_id_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.predmet_id_sequence OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17484)
-- Name: predmet_rok; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.predmet_rok (
    predmet_akronim character varying(255) NOT NULL,
    rok_id bigint NOT NULL,
    datum_polaganja timestamp without time zone NOT NULL
);


ALTER TABLE public.predmet_rok OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17514)
-- Name: predmet_student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.predmet_student (
    broj_indeksa_studenta character varying(255) NOT NULL,
    akronim_predmeta character varying(255) NOT NULL
);


ALTER TABLE public.predmet_student OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 17410)
-- Name: profesor_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profesor_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profesor_id_sequence OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17446)
-- Name: profesor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesor (
    profesor_id bigint DEFAULT nextval('public.profesor_id_sequence'::regclass) NOT NULL,
    ime_profesora character varying(255) NOT NULL,
    prezime_profesora character varying(255) NOT NULL,
    korisnik_id bigint NOT NULL,
    akronim_predmeta character varying(255)
);


ALTER TABLE public.profesor OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 17412)
-- Name: rok_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rok_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rok_id_sequence OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17465)
-- Name: rok; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rok (
    rok_id bigint DEFAULT nextval('public.rok_id_sequence'::regclass) NOT NULL,
    naziv_roka character varying(255) NOT NULL,
    godina bigint NOT NULL
);


ALTER TABLE public.rok OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17737)
-- Name: rola_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rola_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rola_id_sequence OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 17418)
-- Name: rola; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rola (
    rola_id bigint DEFAULT nextval('public.rola_id_sequence'::regclass) NOT NULL,
    naziv_role character varying(255) NOT NULL
);


ALTER TABLE public.rola OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17471)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    broj_indeksa_studenta character varying(255) NOT NULL,
    ime_studenta character varying(255) NOT NULL,
    prezime_studenta character varying(255) NOT NULL,
    upisana_godina bigint NOT NULL,
    studijski_smer character varying(255) NOT NULL,
    korisnik_id bigint NOT NULL
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 17743)
-- Name: student_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_id_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_id_sequence OWNER TO postgres;

--
-- TOC entry 2747 (class 2606 OID 17503)
-- Name: dezurstva_profesora dezurstva_profesora_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dezurstva_profesora
    ADD CONSTRAINT dezurstva_profesora_pkey PRIMARY KEY (predmet_akronim, rok_id, profesor_id);


--
-- TOC entry 2735 (class 2606 OID 17432)
-- Name: korisnik korisnik_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.korisnik
    ADD CONSTRAINT korisnik_pkey PRIMARY KEY (korisnik_id);


--
-- TOC entry 2753 (class 2606 OID 17558)
-- Name: moguce_prijave_student moguce_prijave_studentska_sluzba_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_student
    ADD CONSTRAINT moguce_prijave_studentska_sluzba_pk PRIMARY KEY (predmet_akronim, rok_id, broj_indeksa_studenta);


--
-- TOC entry 2751 (class 2606 OID 17540)
-- Name: moguce_prijave_studentska_sluzba moguce_prijave_studentska_sluzba_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_studentska_sluzba
    ADD CONSTRAINT moguce_prijave_studentska_sluzba_pkey PRIMARY KEY (predmet_akronim, rok_id, broj_indeksa_studenta);


--
-- TOC entry 2745 (class 2606 OID 17488)
-- Name: predmet_rok predmet_datum_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_rok
    ADD CONSTRAINT predmet_datum_pk PRIMARY KEY (predmet_akronim, rok_id);


--
-- TOC entry 2737 (class 2606 OID 17445)
-- Name: predmet predmet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet
    ADD CONSTRAINT predmet_pkey PRIMARY KEY (akronim_predmeta);


--
-- TOC entry 2749 (class 2606 OID 17521)
-- Name: predmet_student predmet_student_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_student
    ADD CONSTRAINT predmet_student_pk PRIMARY KEY (broj_indeksa_studenta, akronim_predmeta);


--
-- TOC entry 2739 (class 2606 OID 17454)
-- Name: profesor profesor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (profesor_id);


--
-- TOC entry 2741 (class 2606 OID 17470)
-- Name: rok rok_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rok
    ADD CONSTRAINT rok_pkey PRIMARY KEY (rok_id);


--
-- TOC entry 2733 (class 2606 OID 17423)
-- Name: rola rola_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rola
    ADD CONSTRAINT rola_pkey PRIMARY KEY (rola_id);


--
-- TOC entry 2743 (class 2606 OID 17478)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (broj_indeksa_studenta);


--
-- TOC entry 2762 (class 2606 OID 17522)
-- Name: predmet_student akronim_predmeta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_student
    ADD CONSTRAINT akronim_predmeta_fk FOREIGN KEY (akronim_predmeta) REFERENCES public.predmet(akronim_predmeta);


--
-- TOC entry 2763 (class 2606 OID 17527)
-- Name: predmet_student broj_indeksa_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_student
    ADD CONSTRAINT broj_indeksa_fk FOREIGN KEY (broj_indeksa_studenta) REFERENCES public.student(broj_indeksa_studenta);


--
-- TOC entry 2758 (class 2606 OID 17489)
-- Name: predmet_rok predmet_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_rok
    ADD CONSTRAINT predmet_fk FOREIGN KEY (predmet_akronim) REFERENCES public.predmet(akronim_predmeta);


--
-- TOC entry 2760 (class 2606 OID 17504)
-- Name: dezurstva_profesora predmet_rok_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dezurstva_profesora
    ADD CONSTRAINT predmet_rok_fk FOREIGN KEY (predmet_akronim, rok_id) REFERENCES public.predmet_rok(predmet_akronim, rok_id);


--
-- TOC entry 2764 (class 2606 OID 17541)
-- Name: moguce_prijave_studentska_sluzba predmet_rok_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_studentska_sluzba
    ADD CONSTRAINT predmet_rok_fk FOREIGN KEY (predmet_akronim, rok_id) REFERENCES public.predmet_rok(predmet_akronim, rok_id);


--
-- TOC entry 2766 (class 2606 OID 17559)
-- Name: moguce_prijave_student predmet_rok_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_student
    ADD CONSTRAINT predmet_rok_fk FOREIGN KEY (predmet_akronim, rok_id) REFERENCES public.predmet_rok(predmet_akronim, rok_id);


--
-- TOC entry 2761 (class 2606 OID 17509)
-- Name: dezurstva_profesora profesor_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dezurstva_profesora
    ADD CONSTRAINT profesor_id_fk FOREIGN KEY (profesor_id) REFERENCES public.profesor(profesor_id);


--
-- TOC entry 2756 (class 2606 OID 17460)
-- Name: profesor profesor_korisnik_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_korisnik_fk FOREIGN KEY (korisnik_id) REFERENCES public.korisnik(korisnik_id);


--
-- TOC entry 2755 (class 2606 OID 17455)
-- Name: profesor profesor_predmet_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_predmet_fk FOREIGN KEY (akronim_predmeta) REFERENCES public.predmet(akronim_predmeta);


--
-- TOC entry 2759 (class 2606 OID 17494)
-- Name: predmet_rok rok_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_rok
    ADD CONSTRAINT rok_fk FOREIGN KEY (rok_id) REFERENCES public.rok(rok_id);


--
-- TOC entry 2754 (class 2606 OID 17433)
-- Name: korisnik rola_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.korisnik
    ADD CONSTRAINT rola_fk FOREIGN KEY (rola_id) REFERENCES public.rola(rola_id);


--
-- TOC entry 2767 (class 2606 OID 17564)
-- Name: moguce_prijave_student student_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_student
    ADD CONSTRAINT student_fk FOREIGN KEY (broj_indeksa_studenta) REFERENCES public.student(broj_indeksa_studenta);


--
-- TOC entry 2765 (class 2606 OID 17546)
-- Name: moguce_prijave_studentska_sluzba studnet_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_studentska_sluzba
    ADD CONSTRAINT studnet_fk FOREIGN KEY (broj_indeksa_studenta) REFERENCES public.student(broj_indeksa_studenta);


--
-- TOC entry 2757 (class 2606 OID 17479)
-- Name: student user_korisnik_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT user_korisnik_fk FOREIGN KEY (korisnik_id) REFERENCES public.korisnik(korisnik_id);


-- Completed on 2018-09-26 04:25:16

--
-- PostgreSQL database dump complete
--

