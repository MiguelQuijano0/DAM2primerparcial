package com.example.planetario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    String[][] datos = {
            {"Mercurio", "Planeta terrestre rocoso", "58,7 horas", "8", "Mercurio es el planeta más pequeño de nuestro sistema solar. Simplemente, es un poco más grande que la Luna de la Tierra. Es el planeta más cercano al Sol, pero no es realmente el más cálido. Venus es el más cálido. Este planeta pequeño da vueltas lentamente comparado con la Tierra, por lo tanto, un día dura un largo tiempo. A Mercurio le lleva 59 días de la Tierra hacer una rotación completa. Un año en Mercurio pasa rápido. Debido a que es el planeta más cercano al Sol, no le lleva mucho tiempo cubrir toda la circunferencia. "},
            {"Venus", "Planeta gaseoso", "243,0187 dias", "8", "Aunque Venus no es el planeta más cercano al Sol, es el más caliente. Tiene una atmósfera densa, llena de dióxido de carbono, que provoca el efecto invernadero, y de nubes compuestas de ácido sulfúrico. Los gases atrapan el calor y mantienen a Venus bien calentito. De hecho, hace tanto calor en Venus que metales como el plomo serían charcos de metal fundido. Venus se ve como un planeta muy activo. Tiene montañas y volcanes. Venus es similar a la Tierra, en tamaño. La Tierra es solo un poco más grande."},
            {"Tierra", "Planeta terrestre", "23h 56m 4.100s", "8", "Nuestro hogar, el planeta Tierra, es un planeta terrestre y rocoso. Tiene una superficie sólida y activa, con montañas, valles, cañones, llanuras y mucho más. La Tierra es especial porque es un planeta océano, ya que el agua cubre el 70% de su superficie. Nuestra atmósferaestá compuesta, en gran parte, por nitrógeno. También tiene mucho oxígeno, que nos permite respirar. Además, nos protege de los meteoroides que se acercan a la Tierra, la mayoría de los cuales se desintegran en nuestra atmósfera antes de llegar a la superficie en forma de meteoritos."},
            {"Marte", "Planeta rocoso", "24h 39min 35s", "7", "Marte es un planeta desértico y frío. Es la mitad del tamaño de la Tierra, y también recibe el nombre de planeta rojo. Es rojo por el hierro oxidado que tiene en el suelo. Como la Tierra, Marte tiene estaciones, casquetes polares, volcanes, cañones y clima. Tiene una atmósfera poco densa hecha de dióxido de carbono, nitrógeno y argón. Hay signos de antiguas inundaciones en Marte, pero ahora el agua existe principalmente en su polvo helado y sus nubes delgadas. En algunas laderas marcianas, se han encontrado pruebas de agua líquida salada."},
            {"Jupiter", "Planeta gaseoso", "9 h 55 m 30 s", "9", "Júpiter es el quinto planeta más cercano del sistema solar y el primero de los planetas gaseosos. Está formado mayoritariamente por gases, por este motivo, es conocido como un gigante gaseoso, igual que Saturno, Urano y Neptuno. Júpiter es uno de los cinco planetas que pueden verse a simple vista desde la Tierra. A pesar de estar a una distancia que alcanza los 600 millones de km de la Tierra, Júpiter es uno de los objetos más brillantes del cielo nocturno, por detrás de Venus y la Luna. Las noches en las que Venus no es visible, Júpiter se convierte en el planeta más brillante del firmamento. Debido a su brillo, Júpiter ya era conocido por las civilizaciones antiguas. Su nombre actual proviene del dios principal de la mitología romana. Antes, los griegos habían asociado este planeta con el dios Zeus."},
            {"Saturno", "Planeta gaseoso", "10 h 33 m 38 s ", "9", "Saturno no es el único planeta que tiene anillos, pero definitivamente tiene los más bellos. Los anillos que vemos están compuestos por grupos de pequeños aros que rodean a Saturno. Están hechos de pedazos de hielo y roca. Como Júpiter, Saturno es una pelota de hidrógeno y helio, en gran parte. Cuando Galileo Galilei vio a Saturno a través de un telescopio en el siglo XVII, no estaba seguro de lo que estaba viendo. Al principio, creyó que estaba mirando tres planetas, o un planeta con asas. Ahora, sabemos que esas eran los anillos de Saturno."},
            {"Urano", "Planeta gaseoso", "1:48", "9", "Urano está compuesto de agua, metano y amoniaco sobre un pequeño centro rocoso. Su atmósfera está hecha de hidrógeno y helio, como Júpiter y Saturno, pero además contiene metano. El metano es lo que le da a Urano el color azul. Urano también tiene anillos tenues. Urano también tiene anillos tenues. Los anillos internos son angostos y oscuros. Los anillos externos tienen colores vivos y son más fáciles de ver. Como Venus, Urano rota en dirección opuesta a la de la mayoría de los otros planetas. Y, a diferencia de cualquier otro planeta, Urano rota de lado."},
            {"Neptuno", "Planeta gaseoso", "367,5 días", "7", "Neptuno es oscuro, frío y muy ventoso. Es el último de los planetas de nuestro sistema solar. Está más de 30 veces más lejos del Sol que la Tierra. Neptuno es muy parecido a Urano. Está compuesto de una espesa mezcla de agua, amoniaco y metano sobre un centro sólido del tamaño de la Tierra. Su atmósfera se compone de hidrógeno, helio y metano. El metano le da a Neptuno el mismo color azul de Urano. Neptuno tiene seis anillos que no se ven fácilmente. Tras el descubrimiento de Urano, se observó que las órbitas de Urano, Saturno y Júpiter no se comportaban tal como predecían las leyes de Kepler y de Newton. Adams y Le Verrier, de forma independiente, calcularon la posición de un hipotético planeta, Neptuno, que finalmente fue encontrado por Galle, el 23 de septiembre de 1846, a menos de un grado de la posición calculada por Le Verrier. Más tarde se advirtió que Galileo ya había observado Neptuno en 1612, pero lo había confundido con una estrella."},
            
    };

    int[] datosImg = {R.drawable.jupiter, R.drawable.marte, R.drawable.mercurio, R.drawable.neptuno, R.drawable.saturno, R.drawable.tierra, R.drawable.urano, R.drawable.venus};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lvLista);

        lista.setAdapter(new Adaptador(this, datos, datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), activity_detalles_planetas.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][4]);
                startActivity(visorDetalles);
                overridePendingTransition(R.anim.left_out,R.anim.left_in);
            }
        });
    }
}