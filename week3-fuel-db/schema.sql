CREATE DATABASE IF NOT EXISTS fuel_calculator_localization
    CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE fuel_calculator_localization;

CREATE TABLE IF NOT EXISTS calculation_records (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    distance    DOUBLE       NOT NULL,
    consumption DOUBLE       NOT NULL,
    price       DOUBLE       NOT NULL,
    total_fuel  DOUBLE       NOT NULL,
    total_cost  DOUBLE       NOT NULL,
    language    VARCHAR(10),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS localization_strings (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    `key`    VARCHAR(100) NOT NULL,
    value    VARCHAR(255) NOT NULL,
    language VARCHAR(10)  NOT NULL,
    UNIQUE KEY unique_key_lang (`key`, `language`)
);

-- English
INSERT IGNORE INTO localization_strings (`key`, value, language) VALUES
('distance.label',    'Distance (km):',                   'en'),
('consumption.label', 'Fuel Consumption (L/100 km):',     'en'),
('price.label',       'Fuel Price (per liter):',          'en'),
('calculate.button',  'Calculate Trip Cost',              'en'),
('result.label',      'Total fuel needed: {0} L | Total cost: {1}', 'en'),
('invalid.input',     'Invalid input. Please enter positive numbers.', 'en');

-- French
INSERT IGNORE INTO localization_strings (`key`, value, language) VALUES
('distance.label',    'Distance (km):',                             'fr'),
('consumption.label', 'Consommation de carburant (L/100 km):',      'fr'),
('price.label',       'Prix du carburant (par litre):',             'fr'),
('calculate.button',  'Calculer le coût du voyage',                 'fr'),
('result.label',      'Carburant nécessaire: {0} L | Coût total: {1}', 'fr'),
('invalid.input',     'Entrée invalide. Veuillez entrer des nombres positifs.', 'fr');

-- Japanese
INSERT IGNORE INTO localization_strings (`key`, value, language) VALUES
('distance.label',    '距離 (km):',                        'ja'),
('consumption.label', '燃料消費量 (L/100 km):',            'ja'),
('price.label',       '燃料価格 (リットル当たり):',        'ja'),
('calculate.button',  '旅行コストを計算',                  'ja'),
('result.label',      '必要燃料: {0} L | 合計コスト: {1}', 'ja'),
('invalid.input',     '無効な入力です。',                  'ja');

-- Persian
INSERT IGNORE INTO localization_strings (`key`, value, language) VALUES
('distance.label',    'فاصله (کیلومتر):',                        'fa'),
('consumption.label', 'مصرف سوخت (L/100 کیلومتر):',             'fa'),
('price.label',       'قیمت سوخت (هر لیتر):',                   'fa'),
('calculate.button',  'محاسبه هزینه سفر',                        'fa'),
('result.label',      'سوخت مورد نیاز: {0} L | هزینه کل: {1}',  'fa'),
('invalid.input',     'ورودی نامعتبر',                           'fa');
