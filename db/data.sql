DELETE	FROM horse_old WHERE race_id IN (SELECT id FROM race_old WHERE race_day_id = 16217);
DELETE 	FROM race_old WHERE race_day_id = 16217;
DELETE 	FROM race_day_old WHERE id = 16217;

INSERT INTO race_day (race_date) 
SELECT race_date FROM race_day_old;

INSERT 	INTO race (venue, time, number_of_runners, race_day_id)
SELECT 	ro.venue, ro.time, ro.number_of_runners, rd.id
FROM 	race_old ro, race_day_old rdo, race_day rd
WHERE	rdo.race_date = rd.race_date
AND		ro.race_day_id = rdo.id;

INSERT 	INTO horse (name, odds, tips, race_id)
SELECT	ho.name, ho.odds, ho.tips, r.id
FROM 	horse_old ho, race_old ro, race_day_old rdo, race_day rd, race r
WHERE 	ho.race_id = ro.id
AND ro.race_day_id = rdo.id
AND r.race_day_id = rd.id
AND rd.race_date = rdo.race_date
AND r.venue = ro.venue
AND r.time = ro.time
AND r.number_of_runners = ro.number_of_runners;