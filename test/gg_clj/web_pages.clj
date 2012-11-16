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