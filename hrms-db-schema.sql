DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    email character varying(50) NOT NULL,
    password character varying(60) NOT NULL,
    is_active boolean DEFAULT false NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT uc_users_email UNIQUE (email)
);

CREATE TABLE public.candidates
(
    candidate_id integer NOT NULL,
    identity_number character(11) NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    year_of_birth character(4) NOT NULL,
    CONSTRAINT pk_candidates PRIMARY KEY (candidate_id),
    CONSTRAINT fk_candidates_users FOREIGN KEY (candidate_id) REFERENCES public.users (id) ON DELETE CASCADE,
    CONSTRAINT uc_candidates_identity_number UNIQUE (identity_number)
);

CREATE TABLE public.employers
(
    employer_id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    web_page character varying(50) NOT NULL,
    phone character varying(12) NOT NULL,
    CONSTRAINT pk_employers PRIMARY KEY (employer_id),
    CONSTRAINT fk_employers_users FOREIGN KEY (employer_id) REFERENCES public.users (id) ON DELETE CASCADE,
    CONSTRAINT uc_employers_phone UNIQUE (phone)
);

CREATE TABLE public.staffs
(
    staff_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    CONSTRAINT pk_staffs PRIMARY KEY (staff_id),
    CONSTRAINT fk_staffs_users FOREIGN KEY (staff_id) REFERENCES public.users (id) ON DELETE CASCADE
);

CREATE TABLE public.verification_codes
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    user_id integer NOT NULL,
    code character varying(38) NOT NULL,
    is_verified boolean DEFAULT false NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_verification_codes PRIMARY KEY (id),
    CONSTRAINT fk_verification_codes_users FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE,
    CONSTRAINT uc_verification_codes_code UNIQUE (code)
);

CREATE TABLE public.staff_confirmations
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    staff_id int NOT NULL,
    is_confirmed boolean DEFAULT false NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_staff_confirmations PRIMARY KEY (id),
    CONSTRAINT fk_staff_confirmations_staffs FOREIGN KEY (staff_id) REFERENCES public.staffs (staff_id) ON DELETE CASCADE
);

CREATE TABLE public.staff_confirmations_employer
(
    employer_confirmation_id integer NOT NULL,
    employer_id int NOT NULL,
    CONSTRAINT pk_staff_confirmations_employer PRIMARY KEY (employer_confirmation_id),
    CONSTRAINT fk_staff_confirmations_employer_staff_confirmations FOREIGN KEY (employer_confirmation_id) REFERENCES public.staff_confirmations (id) ON DELETE CASCADE,
    CONSTRAINT fk_staff_confirmations_employer_employers FOREIGN KEY (employer_id) REFERENCES public.employers (employer_id) ON DELETE CASCADE
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    name character varying(50) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_job_positions PRIMARY KEY (id),
    CONSTRAINT uc_job_positions_name UNIQUE (name)
);

CREATE TABLE public.cities
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    name character varying(20) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_cities PRIMARY KEY (id)
);

CREATE TABLE public.job_adverts
(
	id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    employer_id int NOT NULL,
	job_position_id int NOT NULL,
	city_id int NOT NULL,
	job_definition character varying(500) NOT NULL,
	min_salary int,
	max_salary int,
	open_position_count int NOT NULL,
    deadline date NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_job_adverts PRIMARY KEY (id),
    CONSTRAINT fk_job_adverts_employers FOREIGN KEY (employer_id) REFERENCES public.employers (employer_id) ON DELETE CASCADE,
    CONSTRAINT fk_job_adverts_job_positions FOREIGN KEY (job_position_id) REFERENCES public.job_positions (id) ON DELETE CASCADE,
    CONSTRAINT fk_job_adverts_cities FOREIGN KEY (city_id) REFERENCES public.cities (id) ON DELETE CASCADE 
);

SET TIMEZONE='TURKEY';

INSERT INTO public.cities (name, is_active, created_date) VALUES ('ADANA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ADIYAMAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('AFYON', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('AĞRI', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('AMASYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ANKARA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ANTALYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ARTVİN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('AYDIN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BALIKESİR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BİLECİK', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BİNGÖL', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BİTLİS', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BOLU', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BURDUR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BURSA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ÇANAKKALE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ÇANKIRI', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ÇORUM', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('DENİZLİ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('DİYARBAKIR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('EDİRNE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ELAZIĞ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ERZİNCAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ERZURUM', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ESKİŞEHİR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('GAZİANTEP', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('GİRESUN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('GÜMÜŞHANE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('HAKKARİ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('HATAY', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ISPARTA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('MERSİN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('İSTANBUL', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('İZMİR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KARS', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KASTAMONU', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KAYSERİ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KIRKLARELİ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KIRŞEHİR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KOCAELİ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KONYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KÜTAHYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('MALATYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('MANİSA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KAHRAMANMARAŞ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('MARDİN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('MUĞLA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('MUŞ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('NEVŞEHİR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('NİĞDE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ORDU', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('RİZE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('SAKARYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('SAMSUN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('SİİRT', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('SİNOP', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('SİVAS', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('TEKİRDAĞ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('TOKAT', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('TRABZON', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('TUNCELİ', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ŞANLIURFA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('UŞAK', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('VAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('YOZGAT', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ZONGULDAK', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('AKSARAY', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BAYBURT', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KARAMAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KIRIKKALE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BATMAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ŞIRNAK', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('BARTIN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('ARDAHAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('IĞDIR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('YALOVA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KARABÜK', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('KİLİS', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('OSMANİYE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (name, is_active, created_date) VALUES ('DÜZCE', true, CURRENT_TIMESTAMP);
