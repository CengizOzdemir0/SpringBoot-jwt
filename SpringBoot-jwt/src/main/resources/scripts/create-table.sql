CREATE SCHEMA base;


CREATE TABLE base.kullanici (
                                id SERIAL PRIMARY KEY,
                                ad TEXT NOT NULL,
                                soyad TEXT NOT NULL,
                                email TEXT NOT NULL,
                                password TEXT NOT NULL,
                                uuid UUID NOT NULL
);


CREATE TABLE base.personel (
                               id SERIAL PRIMARY KEY,
                               ad TEXT,
                               soyad TEXT,
                               yas INTEGER,
                               fk_unvan_id INTEGER
);


CREATE TABLE base.personel_meslek (
                                      id SERIAL PRIMARY KEY,
                                      fk_personel_id INTEGER NOT NULL,
                                      meslek_kodu VARCHAR(50) NOT NULL,
                                      meslek_adi VARCHAR(100) NOT NULL,
                                      meslek_giris_tarihi DATE NOT NULL,
                                      FOREIGN KEY (fk_personel_id) REFERENCES base.personel(id) ON DELETE CASCADE
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