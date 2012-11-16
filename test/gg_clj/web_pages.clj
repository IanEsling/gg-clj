(ns gg-clj.web-pages
    	(:import 	[org.jsoup Jsoup]
   				[org.jsoup.nodes Document]))

(defn race-page []
	(Jsoup/parse "<div class=\"leftCol\">
    <h1 class=\"cardHeadline\">
    <strong>12:45</strong>
    <span>
    Venue 1 </span>
    <em>
    HORSE RACING
    TODAY </em>
    </h1>

    <!-- start race info -->
    <h2 class=\"raceTitle\">
    <strong>Oyster Pools And Jacuzzi Raglan Handicap Chase</strong>

    (CLASS 4) (4yo+ 0-115) </h2>
    <p class=\"raceShortInfo clearfix\">
    <span>Winner: <strong>£3,899</strong></span>
    <span>Runners: <strong>17</strong></span> <span>Distance: <strong>3m</strong></span> <span>Going: <strong>Soft </strong></span>
    <span>Channel:
    <em>ATR</em> </span> </p>
    <!-- end race info -->
    </div>

<table id=\"sc_sortBlock\" class=\"cardGrid cardSt\">
    <colgroup>
    <col class=\"trapCol\">
    <col class=\"silkCol\">
    <col class=\"stHorseCol\">
    <col class=\"colB\">
    <col class=\"stJTCol\">
    <col>
    <col>
    </colgroup>
    <thead id=\"sc_cardHead\" class=\"cardHead\">
    </thead>

    <tbody id=\"sc_63518105\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>1</strong><em>1P496</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=134307\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/7/0/3/134307.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=721462\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>NO DEAL</b></a> <img src=\"http://ui.racingpost.com/ico/distance-d.gif\" class=\"cdbf\" alt=\"\"> <span>
    t</span>

    <a href=\"#\" id=\"sc_pencil_721462\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 6%\"></div></div>
    <span>6%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">3</div>
    <div class=\"rpr\">138</div>
    <div class=\"ts\">71 </div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=21070\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Michael O´Hare</a> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=81230\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Mr N McParlan</a><sup>7</sup> </div>
    </td>
    <td class=\"two awo\">
    <div>
    7&nbsp;
    11-8</div>
    <div>
    127</div>
    </td>
    <td class=\"bk\" id=\"sc_63518105_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    <p class=\"diomed\">
    Wetherby winner
    in June;
    not in
    same form
    since.</p>
    <div class=\"forms\">
    <table class=\"grid smallSpaceGrid\">
    <tbody><tr class=\"noSpace\">
    <th class=\"v\">&nbsp;</th>
    <th class=\"date\">DATE</th>
    <th class=\"raceCond\">RACE CONDITIONS</th>
    <th class=\"wgt\">WGT</th>
    <th class=\"raceOut\">RACE OUTCOME</th>
    <th class=\"jock\">JOCKEY</th>
    <th class=\"num\">OR</th>
    <th class=\"num\">TS</th>
    <th class=\"num last\">RPR</th>
    </tr>
    <tr>
    <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;192, 2012-10-29, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 566628, 721462, '2012-10-29', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>
    <td>
    <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=566628&amp;r_date=2012-10-29&amp;popup=yes\" onclick=\"scorecards.send(566628);return Html.popup(this, {width:695, height:800})\" title=\"Copper Face Jacks Supporting Kildare GAA Brown Lad Handicap Hurdle (Grade C)\">29Oct12</a> &nbsp;
    </td>
    <td>
    <b class=\"black\">
    <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=192\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): left-handed, undulating, galloping track (1m4f circuit)\">Naa</a> 20Sft </b>
    HcH 14K</td>
    <td>10-5</td>
    <td>
    <b class=\"black\">6</b>/11 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=566628&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(566628);return Html.popup(this, {width:695, height:800})\" title=\"chased leaders, one pace after 3 out\">(16L Back In A Tic 10-7)</a> t 8/1 </td>
    <td>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=75609\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Robbie Colgan</a> </td>
    <td class=\"num\">116</td>
    <td class=\"num\"><span class=\"red bold\">*</span></td>
    <td class=\"num last\"><span class=\"red bold\">*</span></td>
    </tr>
    <tr>
    <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;185, 2012-07-18, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 560664, 721462, '2012-07-18', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>
    <td>
    <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=560664&amp;r_date=2012-07-18&amp;popup=yes\" onclick=\"scorecards.send(560664);return Html.popup(this, {width:695, height:800})\" title=\"Bunkers Bar Killorglin Handicap Hurdle\">18Jul12</a> &nbsp;
    </td>
    <td>
    <b class=\"black\">
    <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=185\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): left-handed, sharp track (1m2f oval)\">Kln</a> 22Gd/Y </b>
    HcH 12K</td>
    <td>10-11</td>
    <td>
    <b class=\"black\">9</b>/9 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=560664&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(560664);return Html.popup(this, {width:695, height:800})\" title=\"tracked leader in close 2nd, lost place away from 4 out and weakened quickly from next\">(97L Black Benny 10-13)</a> b 20/1 </td>
    <td>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=75609\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Robbie Colgan</a> </td>
    <td class=\"num\">118</td>
    <td class=\"num\"><span class=\"red bold\">*</span></td>
    <td class=\"num last\"><span class=\"red bold\">*</span></td>
    </tr>
    <tr>
    <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;176, 2012-07-07, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 559956, 721462, '2012-07-07', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>
    <td>
    <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=559956&amp;r_date=2012-07-07&amp;popup=yes\" onclick=\"scorecards.send(559956);return Html.popup(this, {width:695, height:800})\" title=\"Seamus Mulvaney Crockafotha Handicap Hurdle\">07Jul12</a> &nbsp;
    </td>
    <td>
    <b class=\"black\">
    <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=176\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): left-handed, sharp, undulating track (1m1f oval)\">Bel</a> 20Sft </b>
    HcH 12K</td>
    <td>10-5</td>
    <td>
    <b class=\"black\">4</b>/8 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=559956&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(559956);return Html.popup(this, {width:695, height:800})\" title=\"led or disputed until mistake 3 out, no extra from next\">(26L Carlingford Lough 10-5)</a> b 7/1 </td>
    <td>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=80633\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Niall P Madden</a> </td>
    <td class=\"num\">119</td>
    <td class=\"num\"><span class=\"red bold\">*</span></td>
    <td class=\"num last\"><span class=\"red bold\">*</span></td>
    </tr>
    <tr>
    <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;180, 2012-06-22, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 559081, 721462, '2012-06-22', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>
    <td>
    <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=559081&amp;r_date=2012-06-22&amp;popup=yes\" onclick=\"scorecards.send(559081);return Html.popup(this, {width:695, height:800})\" title=\"www.thetote.com Galway Plate Trial Handicap Chase\">22Jun12</a> &nbsp;
    </td>
    <td>
    <b class=\"black\">
    <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=180\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, undulating, testing (1m7f circuit)\">Dro</a> 20Sft </b>
    HcCh 12K</td>
    <td>10-7</td>
    <td>
    <b class=\"black\">PU</b>/16 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=559081&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(559081);return Html.popup(this, {width:695, height:800})\" title=\"towards rear for most, never a factor, pulled up before last\">(Mat Hill 9-3)</a> t 7/1 </td>
    <td>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=90392\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Declan Lavery</a> </td>
    <td class=\"num\">128</td>
    <td class=\"num\"><span class=\"red bold\">*</span></td>
    <td class=\"num last\"><span class=\"red bold\">*</span></td>
    </tr>
    <tr>
    <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;87, 2012-06-07, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 555851, 721462, '2012-06-07', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>
    <td>
    <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=555851&amp;r_date=2012-06-07&amp;popup=yes\" onclick=\"scorecards.send(555851);return Html.popup(this, {width:695, height:800})\" title=\"Hold Your Conference Here Novices' Chase\">07Jun12</a> &nbsp;
    </td>
    <td>
    <b class=\"black\">
    <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=87\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): left-handed, galloping track with stiff fences\">Wet</a> 25Sft </b>
    C4NvCh 2K</td>
    <td>10-12</td>
    <td>
    <b class=\"black\">1</b>/3 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=555851&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(555851);return Html.popup(this, {width:695, height:800})\" title=\"with leader, led 9th, went clear on bit approaching 4 out, ridden after 3 out, kept on\">(19L Danimix 10-12)</a> 6/5F </td>
    <td>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=75609\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Robbie Colgan</a> </td>
    <td class=\"num\">124</td>
    <td class=\"num\"><span class=\"red bold\">*</span></td>
    <td class=\"num last\"><span class=\"red bold\">*</span></td>
    </tr>
    <tr>
    <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;195, 2012-04-26, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 553947, 721462, '2012-04-26', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>
    <td>
    <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=553947&amp;r_date=2012-04-26&amp;popup=yes\" onclick=\"scorecards.send(553947);return Html.popup(this, {width:695, height:800})\" title=\"Naas Court Hotel And Il Fico Restaurant Handicap Hurdle\">26Apr12</a> &nbsp;
    </td>
    <td>
    <b class=\"black\">
    <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=195\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, undulating track; hurdle (1m 6f), chase (2m), bank courses\">Pun</a> 24Hy </b>
    HcH 10K</td>
    <td>11-2</td>
    <td>
    <b class=\"black\">PU</b>/24 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=553947&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(553947);return Html.popup(this, {width:695, height:800})\" title=\"prominent early and tracked leaders, 6th halfway, no extra after 5 out and pulled up before 3 out\">(Whatever Jacksays 10-2)</a> tb 20/1 </td>
    <td>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=83612\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Conor Maxwell</a> </td>
    <td class=\"num\">120</td>
    <td class=\"num\"><span class=\"red bold\">*</span></td>
    <td class=\"num last\"><span class=\"red bold\">*</span></td>
    </tr>
    </tbody></table>
    <span id=\"barrier_RPR-TS_In_Form42000994845\" class=\"bar prpTsInfo\"><span id=\"ruli_33\"><span class=\"red bold\">*</span> Historical RP Ratings and Topspeed Ratings are part of Racing Post Members' Club <a href=\"#\" class=\"blue\" onclick=\"javascript:callLogin('special_offer');\"> Log in to view</a></span></span></div>
    <div id=\"sc_raceHorseNotes_721462\" class=\"notes\" style=\"display: none;\"></div>

    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518112\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>2</strong><em>1/11P-</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=20887\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/7/8/8/20887.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=781296\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>CLOUD CREEPER</b></a> <img src=\"http://ui.racingpost.com/ico/distance-d.gif\" class=\"cdbf\" alt=\"\">
    <a href=\"#\" id=\"sc_pencil_781296\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar oddsBarFavorite\">
    <div><div style=\"width: 31%\"></div></div>
    <span>31%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">5</div>
    <div class=\"rpr\">—</div>
    <div class=\"ts\">—</div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=17740\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Tim Vaughan</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">45</span></sup> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=78238\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Dougie Costello</a> </div>
    </td>
    <td class=\"two awo\">
    <div>
    6&nbsp;
    11-1</div>
    <div>
    —</div>
    </td>
    <td class=\"bk\" id=\"sc_63518112_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518108\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>3</strong><em>16374-</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=32188\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/8/8/1/32188.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=753800\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>MANDARIN SUNSET</b></a> <img src=\"http://ui.racingpost.com/ico/distance-d.gif\" class=\"cdbf\" alt=\"\">
    <a href=\"#\" id=\"sc_pencil_753800\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 6%\"></div></div>
    <span>6%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">1</div>
    <div class=\"rpr\">—</div>
    <div class=\"ts\">—</div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=4788\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Sue Smith</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">53</span></sup> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=86359\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Ryan Mania</a> </div>
    </td>
    <td class=\"two awo\">
    <div>
    6&nbsp;
    11-1</div>
    <div>
    —</div>
    </td>
    <td class=\"bk\" id=\"sc_63518108_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518103\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>4</strong><em>915434</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=90048\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/8/4/0/90048.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=696037\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>PHOENIX RETURNS</b></a> <img src=\"http://ui.racingpost.com/ico/distance-d.gif\" class=\"cdbf\" alt=\"\">
    <a href=\"#\" id=\"sc_pencil_696037\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 4%\"></div></div>
    <span>4%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">0</div>
    <div class=\"rpr\">—</div>
    <div class=\"ts\">—</div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=9361\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Shaun Harris</a> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=80135\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Jamie Moore</a> </div>
    </td>
    <td class=\"two awo\">
    <div>
    9&nbsp;
    11-1</div>
    <div>
    —</div>
    </td>
    <td class=\"bk\" id=\"sc_63518103_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518106\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>5</strong><em>4<b>2</b>40-1</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=189036\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/6/3/0/189036.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=733922\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>BRAE ON</b></a> <img src=\"http://ui.racingpost.com/ico/distance-d.gif\" class=\"cdbf\" alt=\"\">
    <a href=\"#\" id=\"sc_pencil_733922\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 24%\"></div></div>
    <span>24%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">0</div>
    <div class=\"rpr\">—</div>
    <div class=\"ts\">—</div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=18127\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Graeme McPherson</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">75</span></sup> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=83173\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Tom Molloy</a><sup>3</sup> </div>
    </td>
    <td class=\"two awo\">
    <div>
    5&nbsp;
    11-1</div>
    <div>
    134</div>
    </td>
    <td class=\"bk\" id=\"sc_63518106_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518102\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>6</strong><em><b>1</b><b>5</b>U2-</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=202837\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/b/7/3/202837b.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=693971\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>TWO OSCARS</b></a>
    <a href=\"#\" id=\"sc_pencil_693971\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 2%\"></div></div>
    <span>2%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">2</div>
    <div class=\"rpr\">92</div>
    <div class=\"ts\">54 </div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=10241\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">R Mike Smith</a> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=90710\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Mr C Bewley</a><sup>7</sup> </div>
    </td>
    <td class=\"two awo\">
    <div>
    9&nbsp;
    11-1</div>
    <div>
    —</div>
    </td>
    <td class=\"bk\" id=\"sc_63518102_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518104\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>7</strong><em>852-66</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=206103\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/3/0/1/206103.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=699929\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>BOLD SLASHER</b></a> <img src=\"http://ui.racingpost.com/ico/distance-d.gif\" class=\"cdbf\" alt=\"\">
    <a href=\"#\" id=\"sc_pencil_699929\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 5%\"></div></div>
    <span>5%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">1</div>
    <div class=\"rpr\">119</div>
    <div class=\"ts\">102 </div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=394\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Malcolm Jefferson</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">29</span></sup> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=84786\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Harry Haynes</a> </div>
    </td>
    <td class=\"two awo\">
    <div>
    8&nbsp;
    11-1</div>
    <div>
    —</div>
    </td>
    <td class=\"bk\" id=\"sc_63518104_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518109\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>8</strong><em>43233</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=102338\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/8/3/3/102338.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=757380\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>BIG SOUND</b></a> <span>
    t</span>

    <a href=\"#\" id=\"sc_pencil_757380\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 3%\"></div></div>
    <span>3%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">4</div>
    <div class=\"rpr\">—</div>
    <div class=\"ts\">—</div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=4087\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Maurice Barnes</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">67</span></sup> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=79437\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Michael McAlister</a> </div>
    </td>
    <td class=\"two awo\">
    <div>
    6&nbsp;
    11-1</div>
    <div>
    —</div>
    </td>
    <td class=\"bk\" id=\"sc_63518109_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518110\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>9</strong><em>213P-6</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=207132\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/2/3/1/207132.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=770686\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>NETMINDER</b></a> <img src=\"http://ui.racingpost.com/ico/distance-d.gif\" class=\"cdbf\" alt=\"\">
    <a href=\"#\" id=\"sc_pencil_770686\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 5%\"></div></div>
    <span>5%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">1</div>
    <div class=\"rpr\">106</div>
    <div class=\"ts\">62 </div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=4471\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Sandy Thomson</a> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=76059\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Peter Buchanan</a> </div>
    </td>
    <td class=\"two awo\">
    <div>
    6&nbsp;
    11-1</div>
    <div>
    —</div>
    </td>
    <td class=\"bk\" id=\"sc_63518110_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518111\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>10</strong><em>3431U-</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=2123\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/3/2/1/2123.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=778376\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>NODFORM RICHARD</b></a> <img src=\"http://ui.racingpost.com/ico/distance-d.gif\" class=\"cdbf\" alt=\"\">
    <a href=\"#\" id=\"sc_pencil_778376\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 6%\"></div></div>
    <span>6%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">1</div>
    <div class=\"rpr\">—</div>
    <div class=\"ts\">—</div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=15674\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Donald McCain</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">59</span></sup> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=13499\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Jason Maguire</a> </div>
    </td>
    <td class=\"two awo\">
    <div>
    6&nbsp;
    11-1</div>
    <div>
    —</div>
    </td>
    <td class=\"bk\" id=\"sc_63518111_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody><tbody id=\"sc_63518107\">
    <tr class=\"cr\">
    <td class=\"t\">
    <strong>11</strong><em>5236-1</em>
    </td>
    <td class=\"s\">
    <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=184484\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/4/8/4/184484.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>

    <td class=\"h\">
    <div class=\"nm\">
    <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=566147&amp;r_date=2012-11-16&amp;horse_id=751958\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>FENTARA</b></a> <img src=\"http://ui.racingpost.com/ico/distance-c.gif\" class=\"cdbf\" alt=\"\"><img src=\"http://ui.racingpost.com/ico/distance-d.gif\" class=\"cdbf\" alt=\"\">
    <a href=\"#\" id=\"sc_pencil_751958\" title=\"Show/Hide My Notes for this runner\"></a> </div>

    <div class=\"oddsBar\">
    <div><div style=\"width: 8%\"></div></div>
    <span>8%</span>
    </div>
    </td>
    <td class=\"two c\">
    <div class=\"tips\">1</div>
    <div class=\"rpr\">—</div>
    <div class=\"ts\">—</div>
    </td>
    <td class=\"two jt\">
    <div>
    <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=41\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Tim Walford</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">100</span></sup> </div>
    <div>
    <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=85596\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Brian Toomey</a><sup>3</sup> </div>
    </td>
    <td class=\"two awo\">
    <div>
    7&nbsp;
    10-8</div>
    <div>
    —</div>
    </td>
    <td class=\"bk\" id=\"sc_63518107_bk\"><button type=\"button\" class=\"btn btnBet btnLight\" title=\"SP with Ladbrokes - Click to bet\"><div><div>SP</div></div></button></td>
    </tr>
    <tr>
    <td class=\"cardItemInfo\" colspan=\"7\">
    
    </td>
    </tr>
    <tr>
    <td colspan=\"7\"><tt><i></i></tt></td>
    </tr>
    </tbody>
    </table>
	<div class=\"info\">
    <p><strong>BETTING FORECAST:&nbsp;</strong><b>7/4 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=803045\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">No Deal</a></b>
                 , 9/4 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=812441\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Cloud Creeper</a>
                 , 6/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=802456\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Mandarin Sunset</a>
                 , 6/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=796948\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Phoenix Returns</a>
                 , 12/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=824123\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Brae On</a>
                 , 16/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=800770\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Two Oscars</a>
                 , 20/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=819631\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Bold Slasher</a>
                 , 25/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=824119\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Big Sound</a>
                 .</p> </div>"))

(defn urls-page []
	(Jsoup/parse "<div id=\"race_result\">
    <div class=\"clearfix\">
    <a href=\"#\" name=\"m1212\"></a><div class=\"leftColumn\">
 <div class=\"headlineBlock headlineBlockMap\">
 <div class=\"h\">
 <h2>
 <a href=\"/horses/cards/multiple_cards.sd?crs_id=1212&amp;r_date=2012-11-11\" onclick=\"scorecards.send(&quot;AMR&quot;)\" title=\"Show all races for the Ffos Las meeting on one page\">Ffos Las</a> </h2>
    <div class=\"i\">
    <a href=\"/horses/cards/multiple_cards.sd?crs_id=1212&amp;r_date=2012-11-11\" onclick=\"scorecards.send(&quot;AMR&quot;)\" title=\"Show all races for the Ffos Las meeting on one page\"><img src=\"http://images.racingpost.com/course_maps/small/ffoslash.jpg\" alt=\"\" width=\"100\" height=\"32\"></a> </div>
    </div>
 <div class=\"ch\">
 <em>ATR </em>
    </div>
 </div>
    <table class=\"table \">
    <colgroup><col class=\"check\">
    <col class=\"time\">
    <col class=\"res\">
    <col class=\"sps\">
    <col class=\"check\">
    <col class=\"time\">
    <col class=\"res\">
    </colgroup><tbody><tr>
 <td>
 <div class=\"firstStar\">
 <a href=\"#\" name=\"race_565750\" class=\"star\" title=\"Add to 'My Race Cards'\"></a><div id=\"buildCardInfoBubble\" class=\"infoBubble\">
    <div class=\"topBg\">
    <div class=\"bgBlock\"><!-- --></div>
 </div>
    <div class=\"infoBubbleWraper\">
    <div class=\"bgBlock\"><!-- --></div>
 <div class=\"infoBubbleContent\">
 <h4>BUILD YOUR OWN PAGE OF<br>RACE CARDS:</h4>
    <p>Select which races you want by<br> clicking the
    <img src=\"http://ui.racingpost.com/release/v17/img/bubble-info/star.17.0.png\" class=\"iepng\" alt=\"x\" title=\"x\" width=\"17\" height=\"16\"> next to the race<br> time, then click <strong>My Race Cards</strong><br> at the top of the page.</p>
    <div class=\"okButton\">
    <button class=\"btn btn btnDark btnActive\" onclick=\"hideInfoBubble('buildCardInfoBubble', '#buildCardInfoBubble');\" title=\"Close\"><div><div>Close</div></div></button> </div>
    </div>
 </div>
    <div class=\"bottomBg\">
    <div class=\"bgBlock\"><!-- --></div>
 </div>
    </div><!-- .infoBubble -->
 </div>
    </td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565750&amp;r_date=2012-11-11\" title=\"wyevalleydemolition.co.uk Novices' Hurdle Cl42m (2m) 4yo+\">12:55</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565750\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_565754\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565754&amp;r_date=2012-11-11\" title=\"Grosvenor Casino Swansea Handicap Hurdle Cl33m (3m) 4yo+\">3:05</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565754\" title=\"View result\">Result</a></td>
    </tr>
 <tr class=\"alt\">
 <td>
 <a href=\"#\" name=\"race_565751\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565751&amp;r_date=2012-11-11\" title=\"Dunraven Windows Novices' Hurdle Cl43m (3m) 4yo+\">1:25</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565751\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_565755\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565755&amp;r_date=2012-11-11\" title=\"Oyster Pools And Jacuzzi Raglan Handicap Chase Cl43m (3m) 4yo+\">3:40</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565755\" title=\"View result\">Result</a></td>
    </tr>
 <tr>
 <td>
 <a href=\"#\" name=\"race_565752\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565752&amp;r_date=2012-11-11\" title=\"AWB Of PD Handicap Chase Cl42m (2m) 4yo+\">2:00</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565752\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_565756\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565756&amp;r_date=2012-11-11\" title=\"Walters UK &quot;Junior&quot; Standard Open National Hunt Flat Race Cl61m6f (1m6f) 3yo\">4:10</a> </strong>
    </td>
<td class=\"bull\">
 &nbsp;</td>
    </tr>
 <tr class=\"alt\">
 <td>
 <a href=\"#\" name=\"race_565753\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565753&amp;r_date=2012-11-11\" title=\"Bathwick Tyres Beginners' Chase Cl32m3½f (2m3f110y) 4yo+\">2:30</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565753\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td> <td></td><td></td><td></td>
    </tr>
 </tbody></table>
</div>





    <a href=\"#\" name=\"m188\"></a><div class=\"rightColumn\">
 <div class=\"headlineBlock headlineBlockMap\">
 <div class=\"h\">
 <h2>
 <a href=\"/horses/cards/multiple_cards.sd?crs_id=188&amp;r_date=2012-11-11\" onclick=\"scorecards.send(&quot;AMR&quot;)\" title=\"Show all races for the Limerick (IRE) meeting on one page\">Limerick (IRE)</a> </h2>
    </div>
 <div class=\"ch\">
 <em>ATR </em>
    </div>
 </div>

    <table class=\"table \">
    <colgroup><col class=\"check\">
    <col class=\"time\">
    <col class=\"res\">
    <col class=\"sps\">
    <col class=\"check\">
    <col class=\"time\">
    <col class=\"res\">
    </colgroup><tbody><tr>
 <td>
 <a href=\"#\" name=\"race_567494\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567494&amp;r_date=2012-11-11\" title=\"Martinstown Opportunity Maiden Hurdle 2m (2m) 4-5yo\">1:05</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567494\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_567498\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567498&amp;r_date=2012-11-11\" title=\"Glenview Stud Beginners Chase 2m3½f (2m3f120y) 4yo+\">3:15</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567498\" title=\"View result\">Result</a></td>
    </tr>
 <tr class=\"alt\">
 <td>
 <a href=\"#\" name=\"race_567495\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567495&amp;r_date=2012-11-11\" title=\"Limerick Racecourse Handicap Hurdle 2m (2m) 4yo+\">1:35</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567495\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_567499\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567499&amp;r_date=2012-11-11\" title=\"Garryowen Veterans Handicap Chase 3m (3m) 9yo+\">3:45</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567499\" title=\"View result\">Result</a></td>
    </tr>
 <tr>
 <td>
 <a href=\"#\" name=\"race_567496\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567496&amp;r_date=2012-11-11\" title=\"Winter Wonderland Maiden Hurdle 2m5f (2m5f) 5yo+\">2:10</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567496\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_567500\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567500&amp;r_date=2012-11-11\" title=\"Limerickraces.ie Online Booking Mares Ladies INH Flat Race 2m (2m) 4-7yo\">4:15</a> </strong>
    </td>
<td class=\"bull\">
 &nbsp;</td>
    </tr>
 <tr class=\"alt\">
 <td>
 <a href=\"#\" name=\"race_567497\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567497&amp;r_date=2012-11-11\" title=\"Newton Abbot Races Handicap Hurdle 2m4f (2m4f) 4yo+\">2:40</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567497\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td> <td></td><td></td><td></td>
    </tr>
 </tbody></table>
</div>




    </div>
 <div class=\"clearfix\">

 
<a href=\"#\" name=\"m35\"></a><div class=\"leftColumn\">
    <div class=\"headlineBlock headlineBlockMap\">
    <div class=\"h\">
    <h2>
    <a href=\"/horses/cards/multiple_cards.sd?crs_id=35&amp;r_date=2012-11-11\" onclick=\"scorecards.send(&quot;AMR&quot;)\" title=\"Show all races for the Market Rasen meeting on one page\">Market Rasen</a> </h2>
    <div class=\"i\">
    <a href=\"/horses/cards/multiple_cards.sd?crs_id=35&amp;r_date=2012-11-11\" onclick=\"scorecards.send(&quot;AMR&quot;)\" title=\"Show all races for the Market Rasen meeting on one page\"><img src=\"http://images.racingpost.com/course_maps/small/marketrasenh.jpg\" alt=\"\" width=\"100\" height=\"32\"></a> </div>
    </div>
 <div class=\"ch\">
 <em>RUK </em>
    </div>
 </div>

    <table class=\"table \">
    <colgroup><col class=\"check\">
    <col class=\"time\">
    <col class=\"res\">
    <col class=\"sps\">
    <col class=\"check\">
    <col class=\"time\">
    <col class=\"res\">
    </colgroup><tbody><tr>
 <td>
 <a href=\"#\" name=\"race_565757\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565757&amp;r_date=2012-11-11\" title=\"Market Rasen Young Farmers Club Juvenile Hurdle Cl42m1f (2m1f) 3yo\">1:10</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565757\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_565760\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565760&amp;r_date=2012-11-11\" title=\"Remembrance Sunday Lest We Forget Handicap Chase Cl43m1f (3m1f) 4yo+\">2:45</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565760\" title=\"View result\">Result</a></td>
    </tr>
 <tr class=\"alt\">
 <td>
 <a href=\"#\" name=\"race_565758\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565758&amp;r_date=2012-11-11\" title=\"ABF Soldiers Charity Novices' Hurdle Cl42m3f (2m3f) 4yo+\">1:40</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565758\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_565761\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565761&amp;r_date=2012-11-11\" title=\"Get Married At Market Rasen Handicap Chase Cl52m4f (2m4f) 4yo+\">3:20</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565761\" title=\"View result\">Result</a></td>
    </tr>
 <tr>
 <td>
 <a href=\"#\" name=\"race_565759\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565759&amp;r_date=2012-11-11\" title=\"Victor Lucas Memorial Novices' Handicap Chase Cl32m6½f (2m6f110y) 4yo+\">2:15</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565759\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_565762\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=565762&amp;r_date=2012-11-11\" title=\"Royal British Legion &quot;Hands And Heels&quot; Handicap Hurdle (For Conditional Jockeys And Amateur Riders) Cl42m3f (2m3f) 4yo+\">3:50</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_565762\" title=\"View result\">Result</a></td>
    </tr>
 </tbody></table>
</div>





    <a href=\"#\" name=\"m193\"></a><div class=\"rightColumn\">
 <div class=\"headlineBlock headlineBlockMap\">
 <div class=\"h\">
 <h2>
 <a href=\"/horses/cards/multiple_cards.sd?crs_id=193&amp;r_date=2012-11-11\" onclick=\"scorecards.send(&quot;AMR&quot;)\" title=\"Show all races for the Navan (IRE) meeting on one page\">Navan (IRE)</a> </h2>
    </div>
 <div class=\"ch\">
 <em>ATR </em>
    </div>
 </div>

    <table class=\"table \">
    <colgroup><col class=\"check\">
    <col class=\"time\">
    <col class=\"res\">
    <col class=\"sps\">
    <col class=\"check\">
    <col class=\"time\">
    <col class=\"res\">
    </colgroup><tbody><tr>
 <td>
 <a href=\"#\" name=\"race_567501\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567501&amp;r_date=2012-11-11\" title=\"Follow Navan Racecourse Facebook 3-Y-O Maiden Hurdle 2m (2m) 3yo\">12:45</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567501\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_567505\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567505&amp;r_date=2012-11-11\" title=\"Irish Form Book Fortria Chase (Grade 2) 2m (2m) 5yo+\">2:50</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567505\" title=\"View result\">Result</a></td>
    </tr>
 <tr class=\"alt\">
 <td>
 <a href=\"#\" name=\"race_567503\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567503&amp;r_date=2012-11-11\" title=\"'For Auction' Novice Hurdle (Grade 3) 2m (2m) 4yo+\">1:15</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567503\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_567506\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567506&amp;r_date=2012-11-11\" title=\"Irish Stallion Farms European Breeders Fund Beginners Chase 2m (2m) 4yo+\">3:25</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567506\" title=\"View result\">Result</a></td>
    </tr>
 <tr>
 <td>
 <a href=\"#\" name=\"race_567502\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567502&amp;r_date=2012-11-11\" title=\"Lismullen Hurdle (Grade 2) 2m4f (2m4f) 4yo+\">1:45</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567502\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td><td>
 <a href=\"#\" name=\"race_567507\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567507&amp;r_date=2012-11-11\" title=\"Martyns Specialist Equipment (Pro/Am) INH Flat Race 2m (2m) 4-7yo\">3:55</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567507\" title=\"View result\">Result</a></td>
    </tr>
 <tr class=\"alt\">
 <td>
 <a href=\"#\" name=\"race_567504\" class=\"star\" title=\"Add to 'My Race Cards'\"></a></td>
<td>
 <strong>
 <a href=\"/horses/cards/card.sd?race_id=567504&amp;r_date=2012-11-11\" title=\"St Johann Ski Resort Tirol Austria Handicap Hurdle 2m7f (2m7f) 4yo+\">2:20</a> </strong>
    </td>
<td class=\"bull\">
 <a href=\"/horses/results/?r_date=2012-11-11#race_567504\" title=\"View result\">Result</a></td>
    <td class=\"sps\"></td> <td></td><td></td><td></td>
    </tr>
 </tbody></table>
</div>
    </div></div>"))