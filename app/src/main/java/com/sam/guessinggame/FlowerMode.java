package com.sam.guessinggame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import com.squareup.picasso.Picasso;

import io.realm.Realm;

public class FlowerMode extends AppCompatActivity {


    private Context context;

    private GestureDetectorCompat detector;
    private ImageView pic;
    private Button op[] = new Button[4];
    private TextView remGuesses;

    String userName;

    private int k;
    private int score;
    private int guesses;

    private String options_num[] = {"A. ", "B. ", "C. " , "D. "};
    private int randomList[] = new int[25];
    private String userIp = "";


    private String animalList[] = new String[]{"https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Aconitum_degenii.jpg/128px-Aconitum_degenii.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/WhiteGazania.JPG/128px-WhiteGazania.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Agapanthus_Postbloom.jpg/256px-Agapanthus_Postbloom.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Ageratum_houstonianum_%27Blue_Mink%27_%28Compositae%29_flowers.JPG/128px-Ageratum_houstonianum_%27Blue_Mink%27_%28Compositae%29_flowers.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/d/de/Alchemilla_alpina0.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Allium_roseum%2C_Pisa.JPG/128px-Allium_roseum%2C_Pisa.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Alstroemeria_aurea_%27Saturne%27.jpg/128px-Alstroemeria_aurea_%27Saturne%27.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Iceland_Plants_4911.JPG/128px-Iceland_Plants_4911.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/b/b3/Amaranthus_tricolor2.jpg",
            "https://www.all-my-favourite-flower-names.com/images/128xNx800px-Amaryllis_hippeastrum_-_Candy_floss.jpg.pagespeed.ic.6UhpYa7xqv.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Wood_anemone_flowers.jpg/128px-Wood_anemone_flowers.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Angelonia_salicariifolia_06.jpg/128px-Angelonia_salicariifolia_06.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Anthurium1.JPG/128px-Anthurium1.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/File-Snapdragons.JPG/128px-File-Snapdragons.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Aquilegia_pyrenaica1JUSA.jpg/128px-Aquilegia_pyrenaica1JUSA.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Purple_Milkweed_Asclepias_purpurascens_Ant.jpg/128px-Purple_Milkweed_Asclepias_purpurascens_Ant.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Aster_amellus_sl_1.jpg/128px-Aster_amellus_sl_1.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Astilbes_in_the_Botanical_Garden_01.JPG/128px-Astilbes_in_the_Botanical_Garden_01.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/2/2d/Astrantia_%28Masterwort_Plant%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Mauve_Flowers_%284541324498%29.jpg/256px-Mauve_Flowers_%284541324498%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Gypsophila_repens_-_close-up_%28aka%29.jpg/128px-Gypsophila_repens_-_close-up_%28aka%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Bachelor%27s_button%2C_Basket_flower%2C_Boutonniere_flower%2C_Cornflower_-_3.jpg/128px-Bachelor%27s_button%2C_Basket_flower%2C_Boutonniere_flower%2C_Cornflower_-_3.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Platycodon_grandiflorus_2.jpg/128px-Platycodon_grandiflorus_2.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Monarda_%27Jacob_Cline%27.JPG/128px-Monarda_%27Jacob_Cline%27.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Begonia_ala_de_drag%C3%B3n_%28Begonia_%C3%97_semperflorens-cultorum%29%2C_jard%C3%ADn_bot%C3%A1nico_de_Tallinn%2C_Estonia%2C_2012-08-13%2C_DD_01.JPG/128px-Begonia_ala_de_drag%C3%B3n_%28Begonia_%C3%97_semperflorens-cultorum%29%2C_jard%C3%ADn_bot%C3%A1nico_de_Tallinn%2C_Estonia%2C_2012-08-13%2C_DD_01.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/9/97/Campanula_alpestris_1.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Bergenia_cordifolia_%28Flower%29.jpg/128px-Bergenia_cordifolia_%28Flower%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Sweet_black_eyed_Susan_bright_yellow_blossoms_with_dark_brown_ceters_flowers_rudbeckia_subtomentosa.jpg/128px-Sweet_black_eyed_Susan_bright_yellow_blossoms_with_dark_brown_ceters_flowers_rudbeckia_subtomentosa.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Gaillardia_x_grandiflora_%27Oranges_and_Lemons%27_in_NH.jpg/128px-Gaillardia_x_grandiflora_%27Oranges_and_Lemons%27_in_NH.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Blazing_Star_and_Little_Sulphur_%285175762535%29.jpg/128px-Blazing_Star_and_Little_Sulphur_%285175762535%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Bleeding_heart_flower_shot.jpg/128px-Bleeding_heart_flower_shot.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Hyacinthoides_non-scripta_001.JPG/128px-Hyacinthoides_non-scripta_001.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Montane_blue-eyed_grass_%28Whitefish_I%29.JPG/128px-Montane_blue-eyed_grass_%28Whitefish_I%29.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Amsonia_ciliata_%27Spring_Sky%27.jpg/128px-Amsonia_ciliata_%27Spring_Sky%27.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Starr_080716-9262_Bouvardia_ternifolia.jpg/128px-Starr_080716-9262_Bouvardia_ternifolia.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/LS_Buddleja_%27Buzz_Lavender%27%2C_panicle.jpg/128px-LS_Buddleja_%27Buzz_Lavender%27%2C_panicle.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Ipomoea_leptophylla_1209058_4x3.jpg/128px-Ipomoea_leptophylla_1209058_4x3.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Buttercup_%28Ranunculus%29_1.JPG/128px-Buttercup_%28Ranunculus%29_1.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Calendula_officinalis_0.0_R.jpg/128px-Calendula_officinalis_0.0_R.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/2/2b/California_poppy_1.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Calla_lily.jpg/128px-Calla_lily.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/5/5c/Campanula_latifolia1.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Iberis_or_Candytuft_from_lalbagh_2084.JPG/128px-Iberis_or_Candytuft_from_lalbagh_2084.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Canna_Lily_%284210867239%29.jpg/128px-Canna_Lily_%284210867239%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Pink_Cape_Primrose.jpg/128px-Pink_Cape_Primrose.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/c/c9/Ruby-throated_hummingbird_on_cardinal_flower_%285871175853%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Red_Carnation_Flower.jpg/128px-Red_Carnation_Flower.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Celosia_wool_flower_from_lalbagh_1718.JPG/128px-Celosia_wool_flower_from_lalbagh_1718.JPG",
            "https://www.all-my-favourite-flower-names.com/images/128xNxFotolia_47824317_XS.jpg.pagespeed.ic.9FokZpUXhH.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/Clarkia_rubicunda_subsp._blasdalei.jpg/128px-Clarkia_rubicunda_subsp._blasdalei.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Clematis_x_Ivan_Olsson.jpg/128px-Clematis_x_Ivan_Olsson.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Melanargia_galathea_Drahkrub.jpg/128px-Melanargia_galathea_Drahkrub.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Cockscomb_%28Celosia_argentea_var._cristata%29.jpg/128px-Cockscomb_%28Celosia_argentea_var._cristata%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Aquilegia_columbine_magpie_cultivar_2.jpg/128px-Aquilegia_columbine_magpie_cultivar_2.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Coneflower.png/128px-Coneflower.png",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Heucheraabramsii.jpg/128px-Heucheraabramsii.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Coreopsis_auriculata_FWS-1.jpg/128px-Coreopsis_auriculata_FWS-1.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/Hummel_auf_Cosmea.jpg/128px-Hummel_auf_Cosmea.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Cotoneaster-multiflorus-flowers.JPG/128px-Cotoneaster-multiflorus-flowers.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/6/62/Geranium_macrorrhizum_stempel_gespleten.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/CreepingPhlox-CentralMA-20140513.jpg/128px-CreepingPhlox-CentralMA-20140513.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Crocosmia_lucifer.jpg/128px-Crocosmia_lucifer.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/d/d5/Crocus_tommasinianus_%27Roseus%27_2.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Fritillaria_imperialis_%27Crown_Imperial%27_%28Liliaceae%29_flower.jpg/128px-Fritillaria_imperialis_%27Crown_Imperial%27_%28Liliaceae%29_flower.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/2014.03.29.-10-Mannheim_Neckarau_Waldpark-Wiesen-Schaumkraut.jpg/256px-2014.03.29.-10-Mannheim_Neckarau_Waldpark-Wiesen-Schaumkraut.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Cyclamen_elegans.jpg/128px-Cyclamen_elegans.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/20140226Narcissus_pseudonarcissus2.jpg/128px-20140226Narcissus_pseudonarcissus2.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Dahlia.%22Erika_Krause%22.7408.jpg/128px-Dahlia.%22Erika_Krause%22.7408.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Daisy_%285970453698%29.jpg/128px-Daisy_%285970453698%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Daphne_bholua_20070226-1505-12.jpg/128px-Daphne_bholua_20070226-1505-12.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Day_Lily_at_the_church.JPG/128px-Day_Lily_at_the_church.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Delphinium_menziesii_5834.JPG/256px-Delphinium_menziesii_5834.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/%22Adenium_obesum%22_Also_known_by_the_names_%22Sabi_Star%2C_Kudu%2C_Mock_Azalea%2C_Impala_Lily_%26_Desert-rose.jpg/128px-%22Adenium_obesum%22_Also_known_by_the_names_%22Sabi_Star%2C_Kudu%2C_Mock_Azalea%2C_Impala_Lily_%26_Desert-rose.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Blue_and_gold_native_bloom.jpg/128px-Blue_and_gold_native_bloom.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Dianthus_toletanus_Closeup_Puertollano.jpg/128px-Dianthus_toletanus_Closeup_Puertollano.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/5717_-_Schynige_Platte_-_Flowers.JPG/128px-5717_-_Schynige_Platte_-_Flowers.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Dietes_grandiflora%2C_d%2C_Springbokpark.jpg/128px-Dietes_grandiflora%2C_d%2C_Springbokpark.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/White_Dutch_irises.jpg/128px-White_Dutch_irises.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/Wallensteinplatz_Echinacea_2010_01.JPG/128px-Wallensteinplatz_Echinacea_2010_01.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Echium_wildpretii_%28flower%29_-_Botanischer_Garten_Bonn.jpg/128px-Echium_wildpretii_%28flower%29_-_Botanischer_Garten_Bonn.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/7/7f/A_real_English_bluebell_in_Lanacre_Wood_-_geograph.org.uk_-_772332.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Erica_australis_a.JPG/128px-Erica_australis_a.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/3/32/Erigeron_glabellus0.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Flower_Bed_%288459543397%29.jpg/128px-Flower_Bed_%288459543397%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Evening_Primrose.JPG/256px-Evening_Primrose.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Yellow_-_orange_flower.jpg/128px-Yellow_-_orange_flower.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Euphorbia_flower_show_2.JPG/128px-Euphorbia_flower_show_2.JPG"
    };

    private String options[][] = new String[][]{{"Aconitum degenii","File-Snapdragons","Platycodon grandiflorus","Amsonia ciliata"},
            {"Clarkia rubicunda subsp. blasdalei","Alchemilla alpina","WhiteGazania","Canna Lily"},
            {"Yellow - orange flower","Bergenia cordifolia","Agapanthus Postbloom","Evening Primrose"},
            {"Alchemilla alpina","Aster amellus sl","Ageratum houstonianum","Montane blue-eyed grass"},
            {"Ageratum houstonianum","Schynige Platte","Alchemilla alpina","Melanargia galathea Drahkrub"},
            {"WhiteGazania","Allium roseum","Coreopsis auriculata","Ipomoea leptophylla"},
            {"Astilbes in the Botanical Garden","White Dutch irises","Alstroemeria aurea","Bachelor's button"},
            {"Iceland Plants","Purple Milkweed Asclepias purpurascens Ant","Adenium obesum (Desert Rose)","Heucheraabramsii"},
            {"Alchemilla alpina","CreepingPhlox-CentralMA","Amaranthus tricolor","Clarkia rubicunda subsp. blasdalei"},
            {"Ruby-throated hummingbird","Amaryllis (Hippeastrum) Flower","Aquilegia columbine magpie cultivar","Cyclamen elegans"},
            {"White Dutch irises","CreepingPhlox-CentralMA","Wood anemone","pseudonarcissus2"},
            {"Clematis x Ivan Olsson","Cotoneaster-multiflorus","Angelonia salicariifolia","Bergenia cordifolia"},
            {"Montane blue-eyed grass","Anthurium1","Amaranthus tricolor","Montane blue-eyed grass"},
            {"Clarkia rubicunda subsp. blasdalei","File-Snapdragons","Red Carnation Flower","Amsonia ciliata"},
            {"Aquilegia pyrenaica1JUSA","Campanula latifolia1","Ruby-throated hummingbird","Coreopsis auriculata"},
            {"Alstroemeria aurea","Allium roseum","Purple Milkweed Asclepias purpurascens Ant","Yellow - orange flower"},
            {"Campanula latifolia1","Aster amellus sl","Begonia ala de dragÃ","Monarda 'Jacob Cline'"},
            {"Daisy","Astilbes in the Botanical Garden","English bluebell","Iceland Plants"},
            {"Fritillaria imperialis 'Crown Imperial'","Astrantia (Masterwort Plant)","Heucheraabramsii","None"},
            {"Mauve Flowers","Agapanthus Postbloom","Euphorbia flower show","File-Snapdragons"},
            {"Evening Primrose","Gypsophila repens","Daisy","Dahlia"},
            {"Geranium macrorrhizum stempel gespleten","Bachelor's button","Anthurium1","Astilbes in the Botanical Garden"},
            {"CreepingPhlox-CentralMA","Rudbeckia Subtomentosa","Platycodon grandiflorus","Purple Milkweed Asclepias purpurascens Ant"},
            {"Cyclamen elegans","Monarda 'Jacob Cline'","Montane blue-eyed grass","Bachelor's button"},
            {"Ageratum houstonianum","Bleeding heart","Begonia ala de dragÃ","Calla lily"},
            {"Campanula alpestris","Red Carnation Flower","Iberis (Candytuft)","Amaranthus tricolor"},
            {"English bluebell","Pink Cape Primrose","Bergenia cordifolia","Crocus tommasinianus 'Roseus'"},
            {"Rudbeckia Subtomentosa","Platycodon grandiflorus","Pink Cape Primrose","Blue and gold native bloom"},
            {"Bergenia cordifolia","Dahlia","Gaillardia","Crocosmia lucifer"},
            {"Flower Bed","Ageratum houstonianum","Blazing Star","Blue and gold native bloom"},
            {"Calla lily","Euphorbia flower show","Bleeding heart","Clarkia rubicunda subsp. blasdalei"},
            {"Campanula latifolia1","Angelonia salicariifolia","Hyacinthoides","Angelonia salicariifolia"},
            {"Aster amellus sl","Ipomoea leptophylla","Montane blue-eyed grass","White Dutch irises"},
            {"Amsonia ciliata","Amaranthus tricolor","pseudonarcissus2","Day Lily"},
            {"Starr Bouvardia ternifolia","Campanula latifolia1","Hummel auf Cosmea","Montane blue-eyed grass"},
            {"File-Snapdragons","LS Buddleja 'Buzz Lavender'","Melanargia galathea Drahkrub","Geranium macrorrhizum stempel gespleten"},
            {"Evening Primrose","Ipomoea leptophylla","Crocosmia lucifer","File-Snapdragons"},
            {"Melanargia galathea Drahkrub","Buttercup (Ranunculus)","Mauve Flowers","Euphorbia flower show"},
            {"Astrantia (Masterwort Plant)","Geranium macrorrhizum stempel gespleten","Calendula officinalis","Bachelor's button"},
            {"Amaranthus tricolor","Crocosmia lucifer","California poppy","Cockscomb"},
            {"Calla lily","Blazing Star","Day Lily","Ruby-throated hummingbird"},
            {"Geranium macrorrhizum stempel gespleten","Erigeron glabellus","Campanula latifolia1","pseudonarcissus2"},
            {"Bergenia cordifolia","Iberis (Candytuft)","Adenium obesum (Desert Rose)","Bachelor's button"},
            {"Wallensteinplatz Echinacea","Pink Cape Primrose","Canna Lily","Coreopsis auriculata"},
            {"Pink Cape Primrose","Bleeding heart","Dietes grandiflora","Gaillardia"},
            {"Dianthus toletanus Closeup Puertollano","WhiteGazania","Ruby-throated hummingbird","Adenium obesum (Desert Rose)"},
            {"Red Carnation Flower","CreepingPhlox-CentralMA","Clarkia rubicunda subsp. blasdalei","English bluebell"},
            {"Clematis x Ivan Olsson","Celosia wool flower","Montane blue-eyed grass","Wood anemone"},
            {"Iceland Plants","Crocus tommasinianus 'Roseus'","None","Wood anemone"},
            {"Blue and gold native bloom","Clarkia rubicunda subsp. blasdalei","LS Buddleja 'Buzz Lavender'","Wallensteinplatz Echinacea"},
            {"File-Snapdragons","Yellow - orange flower","Clematis x Ivan Olsson","Platycodon grandiflorus"},
            {"Melanargia galathea Drahkrub","Pink Cape Primrose","Schynige Platte","Evening Primrose"},
            {"Ipomoea leptophylla","Cockscomb","California poppy","Aster amellus sl"},
            {"Aquilegia columbine magpie cultivar","Melanargia galathea Drahkrub","Geranium macrorrhizum stempel gespleten","Coreopsis auriculata"},
            {"Astilbes in the Botanical Garden","Coneflower","Erica australis","pseudonarcissus2"},
            {"Adenium obesum (Desert Rose)","Buttercup (Ranunculus)","Heucheraabramsii","Amsonia ciliata"},
            {"Coreopsis auriculata","pseudonarcissus2","Astrantia (Masterwort Plant)","Bachelor's button"},
            {"Montane blue-eyed grass","Hummel auf Cosmea","Day Lily","Aconitum degenii"},
            {"Erica australis","Cotoneaster-multiflorus","Calendula officinalis","None"},
            {"Clematis x Ivan Olsson","Amaranthus tricolor","Geranium macrorrhizum stempel gespleten","Crocosmia lucifer"},
            {"CreepingPhlox-CentralMA","Canna Lily","Evening Primrose","Campanula latifolia1"},
            {"Crocosmia lucifer","Gaillardia","Amsonia ciliata","Cockscomb"},
            {"Dianthus toletanus Closeup Puertollano","Crocus tommasinianus 'Roseus'","Dahlia","Erigeron glabellus"},
            {"Fritillaria imperialis 'Crown Imperial'","Alstroemeria aurea","Rudbeckia Subtomentosa","Yellow - orange flower"},
            {"Echium wildpretii","Mannheim Neckarau","Alchemilla alpina","Campanula alpestris"},
            {"Cyclamen elegans","Gypsophila repens","Rudbeckia Subtomentosa","Gypsophila repens"},
            {"pseudonarcissus2","Melanargia galathea Drahkrub","English bluebell","Campanula latifolia1"},
            {"Dahlia","Cotoneaster-multiflorus","Calendula officinalis","pseudonarcissus2"},
            {"Erigeron glabellus","Daisy","Wood anemone","Delphinium menziesii"},
            {"Ruby-throated hummingbird","Geranium macrorrhizum stempel gespleten","Daphne bholua","Rudbeckia Subtomentosa"},
            {"Heucheraabramsii","Day Lily","Buttercup (Ranunculus)","Iceland Plants"},
            {"Delphinium menziesii","Blue and gold native bloom","Calla lily","Campanula latifolia1"},
            {"Amaranthus tricolor","Dianthus toletanus Closeup Puertollano","Adenium obesum (Desert Rose)","Coneflower"},
            {"Ageratum houstonianum","Aconitum degenii","Blue and gold native bloom","Dahlia"},
            {"Dianthus toletanus Closeup Puertollano","Yellow - orange flower","Iberis (Candytuft)","Rudbeckia Subtomentosa"},
            {"Alchemilla alpina","Schynige Platte","Flower Bed","Begonia ala de dragÃ"},
            {"Rudbeckia Subtomentosa","Wallensteinplatz Echinacea","Dietes grandiflora","Allium roseum"},
            {"White Dutch irises","Ageratum houstonianum","Mannheim Neckarau","Allium roseum"},
            {"Wallensteinplatz Echinacea","Daisy","Ageratum houstonianum","Cotoneaster-multiflorus"},
            {"Platycodon grandiflorus","Yellow - orange flower","Echium wildpretii","Flower Bed"},
            {"Aquilegia pyrenaica1JUSA","Buttercup (Ranunculus)","English bluebell","Bleeding heart"},
            {"Anthurium1","Angelonia salicariifolia","Erica australis","Monarda 'Jacob Cline'"},
            {"Crocosmia lucifer","Erigeron glabellus","Buttercup (Ranunculus)","Anthurium1"},
            {"Aquilegia pyrenaica1JUSA","Alstroemeria aurea","Flower Bed","Anthurium1"},
            {"Astilbes in the Botanical Garden","Evening Primrose","Ageratum houstonianum","Ipomoea leptophylla"},
            {"Melanargia galathea Drahkrub","Hyacinthoides","Yellow - orange flower","Dietes grandiflora"},
            {"Aconitum degenii","Euphorbia flower show","Buttercup (Ranunculus)","Platycodon grandiflorus"},
    };
    private String ans[] = new String[]{"Aconitum degenii",
            "WhiteGazania",
            "Agapanthus Postbloom",
            "Ageratum houstonianum",
            "Alchemilla alpina",
            "Allium roseum",
            "Alstroemeria aurea",
            "Iceland Plants",
            "Amaranthus tricolor",
            "Amaryllis (Hippeastrum) Flower",
            "Wood anemone",
            "Angelonia salicariifolia",
            "Anthurium1",
            "File-Snapdragons",
            "Aquilegia pyrenaica1JUSA",
            "Purple Milkweed Asclepias purpurascens Ant",
            "Aster amellus sl",
            "Astilbes in the Botanical Garden",
            "Astrantia (Masterwort Plant)",
            "Mauve Flowers",
            "Gypsophila repens",
            "Bachelor's button",
            "Platycodon grandiflorus",
            "Monarda 'Jacob Cline'",
            "Begonia ala de dragÃ",
            "Campanula alpestris",
            "Bergenia cordifolia",
            "Rudbeckia Subtomentosa",
            "Gaillardia",
            "Blazing Star",
            "Bleeding heart",
            "Hyacinthoides",
            "Montane blue-eyed grass",
            "Amsonia ciliata",
            "Starr Bouvardia ternifolia",
            "LS Buddleja 'Buzz Lavender'",
            "Ipomoea leptophylla",
            "Buttercup (Ranunculus)",
            "Calendula officinalis",
            "California poppy",
            "Calla lily",
            "Campanula latifolia1",
            "Iberis (Candytuft)",
            "Canna Lily",
            "Pink Cape Primrose",
            "Ruby-throated hummingbird",
            "Red Carnation Flower",
            "Celosia wool flower",
            "None",
            "Clarkia rubicunda subsp. blasdalei",
            "Clematis x Ivan Olsson",
            "Melanargia galathea Drahkrub",
            "Cockscomb",
            "Aquilegia columbine magpie cultivar",
            "Coneflower",
            "Heucheraabramsii",
            "Coreopsis auriculata",
            "Hummel auf Cosmea",
            "Cotoneaster-multiflorus",
            "Geranium macrorrhizum stempel gespleten",
            "CreepingPhlox-CentralMA",
            "Crocosmia lucifer",
            "Crocus tommasinianus 'Roseus'",
            "Fritillaria imperialis 'Crown Imperial'",
            "Mannheim Neckarau",
            "Cyclamen elegans",
            "pseudonarcissus2",
            "Dahlia",
            "Daisy",
            "Daphne bholua",
            "Day Lily",
            "Delphinium menziesii",
            "Adenium obesum (Desert Rose)",
            "Blue and gold native bloom",
            "Dianthus toletanus Closeup Puertollano",
            "Schynige Platte",
            "Dietes grandiflora",
            "White Dutch irises",
            "Wallensteinplatz Echinacea",
            "Echium wildpretii",
            "English bluebell",
            "Erica australis",
            "Erigeron glabellus",
            "Flower Bed",
            "Evening Primrose",
            "Yellow - orange flower",
            "Euphorbia flower show"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower_mode);

        // initialising components
        context = this;
        detector = new GestureDetectorCompat(this, new FlowerMode.GestureListener());
        pic = findViewById(R.id.picture_fragment);
        op[0] = findViewById(R.id.op1);
        op[1] = findViewById(R.id.op2);
        op[2] = findViewById(R.id.op3);
        op[3] = findViewById(R.id.op4);
        remGuesses = findViewById(R.id.rem_guess);

        // getting user name
        Bundle b = getIntent().getBundleExtra("cred");
        userName = b.getString("name");


        // initialising k, guess and score
        k = 0;
        score = 0;
        guesses = 5;

        remGuesses.setText(String.valueOf(guesses));

        // creating the randomList to fetch corresponding pics
        for(int i = 0; i < 25; i++) {
            randomList[i] = (int) (Math.random() * animalList.length) % animalList.length;
        }


        changeQuestion();

        pic.setOnTouchListener(touchListener);

    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return detector.onTouchEvent(motionEvent);
        }
    };

    class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_MIN_DISTANCE = 60;
        private static final int SWIPE_THRESHOLD_VELOCITY = 100;


        @Override
        public boolean onDown(MotionEvent event) {
            return true;
        }


        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(k < 24 && guesses > 0) {

                guesses -= 1;
                k += 1;
                remGuesses.setText(String.valueOf(guesses));


                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                Player player = realm.where(Player.class).equalTo("name", userName).findFirst();
                player.setRecentScore(score);
                if(player.getRecentScore() > player.getMax_score()) {
                    player.setMax_score(player.getRecentScore());
                }
                realm.commitTransaction();
                realm.close();

                changeQuestion();

            } else {
                gameOver();
            }


            return true;
        }


    }


    public void optionA(View view) {

        userIp = options[randomList[k]][0];

        operation(userIp);
    }

    public void optionB(View view) {

        userIp = options[randomList[k]][1];

        operation(userIp);
    }

    public void optionC(View view) {

        userIp = options[randomList[k]][2];

        operation(userIp);
    }

    public void optionD(View view) {

        userIp = options[randomList[k]][3];

        operation(userIp);
    }

    public void operation(String ip) {
        if(ans[randomList[k]] == ip) {
            score += 5;
        } else {
            if(score >= 5) {
                score -= 5;
            }
        }

        if(k < 24 && guesses > 0) {
            k++;
            changeQuestion();


        } else {
            gameOver();
        }

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Player player = realm.where(Player.class).equalTo("name", userName).findFirst();
        player.setRecentScore(score);
        if(player.getRecentScore() > player.getMax_score()) {
            player.setMax_score(player.getRecentScore());
        }

//        Toast.makeText(this, score + " " + ans[randomList[k]] + " " + k, Toast.LENGTH_SHORT).show();
        realm.commitTransaction();
        realm.close();
    }

    public void changeQuestion() {
        Picasso.get()
                .load(animalList[randomList[k]])
                .resize(300,300)
                .centerCrop()
                .into(pic);



        for(int i = 0; i < 4; i++) {
            op[i].setText(options_num[i] + options[randomList[k]][i]);
        }

    }

    public void gameOver() {

        Intent intent = new Intent(this, GameOver.class);
        Bundle b = new Bundle();
        b.putInt("score", score);
        b.putString("name", userName);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }


}
