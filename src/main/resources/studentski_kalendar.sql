--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-09-24 07:25:13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 204 (class 1259 OID 16896)
-- Name: dezurstva_profesora; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dezurstva_profesora (
    predmet_akronim character varying(255) NOT NULL,
    rok_id bigint NOT NULL,
    profesor_id bigint NOT NULL
);


ALTER TABLE public.dezurstva_profesora OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16966)
-- Name: moguce_prijave_student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.moguce_prijave_student (
    predmet_akronim character varying(255) NOT NULL,
    rok_id bigint NOT NULL,
    broj_indeksa character varying(255) NOT NULL,
    ocena bigint
);


ALTER TABLE public.moguce_prijave_student OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16947)
-- Name: moguce_prijave_studentska_sluzba; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.moguce_prijave_studentska_sluzba (
    predmet_akronim character varying(255) NOT NULL,
    rok_id bigint NOT NULL,
    broj_indeksa character(255) NOT NULL,
    cena_prijave bigint DEFAULT 0,
    status_prijave character varying(255)
);


ALTER TABLE public.moguce_prijave_studentska_sluzba OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16779)
-- Name: predmet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.predmet (
    akronim character varying(255) NOT NULL,
    naziv character varying(255) NOT NULL,
    tip_predmeta character varying(255) NOT NULL,
    godina_studija character varying(255) NOT NULL
);


ALTER TABLE public.predmet OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17167)
-- Name: predmet_rok; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.predmet_rok (
    predmet_akronim character varying(255) NOT NULL,
    rok_id bigint NOT NULL,
    datum timestamp without time zone NOT NULL
);


ALTER TABLE public.predmet_rok OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16911)
-- Name: predmet_student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.predmet_student (
    broj_indeksa_studenta character varying(255) NOT NULL,
    akronim_predmeta character varying(255) NOT NULL
);


ALTER TABLE public.predmet_student OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16767)
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
-- TOC entry 201 (class 1259 OID 16822)
-- Name: profesor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesor (
    profesor_id bigint DEFAULT nextval('public.profesor_id_sequence'::regclass) NOT NULL,
    ime character varying(255) NOT NULL,
    prezime character varying(255) NOT NULL,
    rola bigint NOT NULL,
    predmet character varying(255)
);


ALTER TABLE public.profesor OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16769)
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
-- TOC entry 202 (class 1259 OID 16847)
-- Name: rok; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rok (
    rok_id bigint DEFAULT nextval('public.rok_id_sequence'::regclass) NOT NULL,
    naziv character varying(255) NOT NULL,
    godina bigint NOT NULL
);


ALTER TABLE public.rok OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16771)
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
-- TOC entry 199 (class 1259 OID 16773)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint DEFAULT nextval('public.rola_id_sequence'::regclass) NOT NULL,
    role character varying(255) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16853)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    broj_indeksa character varying(255) NOT NULL,
    ime character varying(255) NOT NULL,
    prezime character varying(255) NOT NULL,
    upisana_godina bigint NOT NULL,
    studijski_smer character varying(255) NOT NULL,
    rola bigint NOT NULL
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16984)
-- Name: user_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_sequence OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17145)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id bigint DEFAULT nextval('public.user_id_sequence'::regclass) NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    rola bigint NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 2739 (class 2606 OID 16900)
-- Name: dezurstva_profesora dezurstva_profesora_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dezurstva_profesora
    ADD CONSTRAINT dezurstva_profesora_pkey PRIMARY KEY (predmet_akronim, rok_id, profesor_id);


--
-- TOC entry 2745 (class 2606 OID 16973)
-- Name: moguce_prijave_student moguce_prijave_studentska_sluzba_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_student
    ADD CONSTRAINT moguce_prijave_studentska_sluzba_pk PRIMARY KEY (predmet_akronim, rok_id, broj_indeksa);


--
-- TOC entry 2743 (class 2606 OID 16955)
-- Name: moguce_prijave_studentska_sluzba moguce_prijave_studentska_sluzba_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_studentska_sluzba
    ADD CONSTRAINT moguce_prijave_studentska_sluzba_pkey PRIMARY KEY (predmet_akronim, rok_id, broj_indeksa);


--
-- TOC entry 2749 (class 2606 OID 17171)
-- Name: predmet_rok predmet_datum_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_rok
    ADD CONSTRAINT predmet_datum_pk PRIMARY KEY (predmet_akronim, rok_id);


--
-- TOC entry 2731 (class 2606 OID 16786)
-- Name: predmet predmet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet
    ADD CONSTRAINT predmet_pkey PRIMARY KEY (akronim);


--
-- TOC entry 2741 (class 2606 OID 16918)
-- Name: predmet_student predmet_student_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_student
    ADD CONSTRAINT predmet_student_pk PRIMARY KEY (broj_indeksa_studenta, akronim_predmeta);


--
-- TOC entry 2733 (class 2606 OID 16830)
-- Name: profesor profesor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (profesor_id);


--
-- TOC entry 2735 (class 2606 OID 16852)
-- Name: rok rok_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rok
    ADD CONSTRAINT rok_pkey PRIMARY KEY (rok_id);


--
-- TOC entry 2729 (class 2606 OID 16777)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2737 (class 2606 OID 16860)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (broj_indeksa);


--
-- TOC entry 2747 (class 2606 OID 17153)
-- Name: users user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2756 (class 2606 OID 16924)
-- Name: predmet_student akronim_predmeta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_student
    ADD CONSTRAINT akronim_predmeta_fk FOREIGN KEY (akronim_predmeta) REFERENCES public.predmet(akronim);


--
-- TOC entry 2755 (class 2606 OID 16919)
-- Name: predmet_student broj_indeksa_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_student
    ADD CONSTRAINT broj_indeksa_fk FOREIGN KEY (broj_indeksa_studenta) REFERENCES public.student(broj_indeksa);


--
-- TOC entry 2758 (class 2606 OID 17192)
-- Name: moguce_prijave_studentska_sluzba fk5l1ffwuww3jgendw3iyxj017p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_studentska_sluzba
    ADD CONSTRAINT fk5l1ffwuww3jgendw3iyxj017p FOREIGN KEY (predmet_akronim, rok_id) REFERENCES public.predmet_rok(predmet_akronim, rok_id);


--
-- TOC entry 2760 (class 2606 OID 17187)
-- Name: moguce_prijave_student fk998dg22610yiivmvuykruw4x9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_student
    ADD CONSTRAINT fk998dg22610yiivmvuykruw4x9 FOREIGN KEY (predmet_akronim, rok_id) REFERENCES public.predmet_rok(predmet_akronim, rok_id);


--
-- TOC entry 2754 (class 2606 OID 17182)
-- Name: dezurstva_profesora fkdargqww28g82hg3tauvotfqoi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dezurstva_profesora
    ADD CONSTRAINT fkdargqww28g82hg3tauvotfqoi FOREIGN KEY (predmet_akronim, rok_id) REFERENCES public.predmet_rok(predmet_akronim, rok_id);


--
-- TOC entry 2762 (class 2606 OID 17172)
-- Name: predmet_rok predmet_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_rok
    ADD CONSTRAINT predmet_fk FOREIGN KEY (predmet_akronim) REFERENCES public.predmet(akronim);


--
-- TOC entry 2753 (class 2606 OID 16906)
-- Name: dezurstva_profesora profesor_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dezurstva_profesora
    ADD CONSTRAINT profesor_id_fk FOREIGN KEY (profesor_id) REFERENCES public.profesor(profesor_id);


--
-- TOC entry 2751 (class 2606 OID 17159)
-- Name: profesor profesor_predmet_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_predmet_fk FOREIGN KEY (predmet) REFERENCES public.predmet(akronim);


--
-- TOC entry 2750 (class 2606 OID 16836)
-- Name: profesor profesor_rola_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_rola_fk FOREIGN KEY (rola) REFERENCES public.role(id);


--
-- TOC entry 2763 (class 2606 OID 17177)
-- Name: predmet_rok rok_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.predmet_rok
    ADD CONSTRAINT rok_fk FOREIGN KEY (rok_id) REFERENCES public.rok(rok_id);


--
-- TOC entry 2761 (class 2606 OID 17154)
-- Name: users role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT role_fk FOREIGN KEY (rola) REFERENCES public.role(id);


--
-- TOC entry 2759 (class 2606 OID 16979)
-- Name: moguce_prijave_student student_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_student
    ADD CONSTRAINT student_fk FOREIGN KEY (broj_indeksa) REFERENCES public.student(broj_indeksa);


--
-- TOC entry 2757 (class 2606 OID 16961)
-- Name: moguce_prijave_studentska_sluzba studnet_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moguce_prijave_studentska_sluzba
    ADD CONSTRAINT studnet_fk FOREIGN KEY (broj_indeksa) REFERENCES public.student(broj_indeksa);


--
-- TOC entry 2752 (class 2606 OID 16861)
-- Name: student user_rola_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT user_rola_fk FOREIGN KEY (rola) REFERENCES public.role(id);


-- Completed on 2018-09-24 07:25:13

--
-- PostgreSQL database dump complete
--

