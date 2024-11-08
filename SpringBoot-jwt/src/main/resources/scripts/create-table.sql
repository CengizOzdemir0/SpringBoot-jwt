CREATE SCHEMA base;


CREATE TABLE base.kullanici (
                                id SERIAL PRIMARY KEY,
                                ad TEXT NOT NULL,
                                soyad TEXT NOT NULL,
                                email TEXT NOT NULL,
                                password TEXT NOT NULL,
                                uuid UUID NOT NULL
);






CREATE TABLE base.unvan (
                            id SERIAL PRIMARY KEY,
                            unvan_kodu VARCHAR(50) NOT NULL,
                            unvan_adi VARCHAR(100) NOT NULL,
                            unvan_verilis_tarihi DATE NOT NULL,
                            unvan_guncellenme_tarihi DATE,
                            unvan_guncelleyen_personel_id INTEGER,
                            FOREIGN KEY (unvan_guncelleyen_personel_id) REFERENCES base.personel(id) ON DELETE SET NULL
);

CREATE TABLE base.rol_yetki (
                                id SERIAL PRIMARY KEY,
                                fk_rol_id serial NOT NULL,
                                fk_yetki_id serial NOT NULL

);

CREATE TABLE base.yetki (
                            id SERIAL PRIMARY KEY,
                            adi text NOT NULL,
                            aciklama text NOT null


);

CREATE TABLE base.rol (
                          id SERIAL PRIMARY KEY,
                          adi text NOT NULL,
                          aciklama text NOT null


);

CREATE TABLE base.kullanici_rol (
                                    id SERIAL PRIMARY KEY,
                                    fk_kullanici_id serial NOT NULL,
                                    fk_rol_id serial NOT NULL

);
