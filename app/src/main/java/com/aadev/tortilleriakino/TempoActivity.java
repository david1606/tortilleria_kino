
package com.aadev.tortilleriakino;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.aadev.tortilleriakino.Classes.Clients;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;

public class TempoActivity extends AppCompatActivity {
    private ArrayList<Clients> clients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo);

        clients = new ArrayList<Clients>() {{
        }};

        clients.add(new Clients("1", "Maricela", Arrays.asList(6, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ortiz", Arrays.asList(6, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Yaqui 1", Arrays.asList(10, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Vianney", Arrays.asList(10, 5, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Los Portales", Arrays.asList(8, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Valles Nueva", Arrays.asList(3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ab Zoad", Arrays.asList(4, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Gusanito", Arrays.asList(10, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "La Bonita", Arrays.asList(4, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Melly", Arrays.asList(7, 10, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Exp Paseo Parque", Arrays.asList(0, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Juanita", Arrays.asList(6, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Takis", Arrays.asList(3, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Palermo", Arrays.asList(3, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Roma", Arrays.asList(4, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ramiro", Arrays.asList(5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Santa Cruz", Arrays.asList(0, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Tienda Nueva", Arrays.asList(3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Sofia", Arrays.asList(8, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Chapis", Arrays.asList(5, 6, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Yeye", Arrays.asList(10, 8, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Even", Arrays.asList(8, 6, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ab Chuy SantaFe", Arrays.asList(0, 10, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Chicoros", Arrays.asList(15, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Lara", Arrays.asList(5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Rosy", Arrays.asList(8, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "El Campanario 1", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "El Campanario 2", Arrays.asList(3, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Mixteco", Arrays.asList(2, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Quintero", Arrays.asList(14, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Pato", Arrays.asList(7, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "La Familia", Arrays.asList(8, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Tiendita", Arrays.asList(4, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ab Paseo Verano", Arrays.asList(8, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Jarman", Arrays.asList(5, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ab Ronaldo", Arrays.asList(3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Guasima", Arrays.asList(7, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Lesly", Arrays.asList(8, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Arrollo", Arrays.asList(0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Pichorro", Arrays.asList(0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Genesis", Arrays.asList(0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ab Ricky", Arrays.asList(0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "La Primera", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Naydelin", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Sñra TKT", Arrays.asList(0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ciber", Arrays.asList(0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Yuly", Arrays.asList(0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Bambu", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Peke", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Callejon", Arrays.asList(0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Paloma", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Viviana", Arrays.asList(0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ladrillera", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Doña Mague", Arrays.asList(0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ab Luis", Arrays.asList(0, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Jaquelin Ladrillera", Arrays.asList(0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Rojo", Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Av 10", Arrays.asList(4, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Alex", Arrays.asList(3, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Bodegúita", Arrays.asList(5, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Joshua", Arrays.asList(0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ab Mendez (PN)", Arrays.asList(0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Erika Yonque", Arrays.asList(4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Frente Secu", Arrays.asList(0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Luly", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "ALEX1S", Arrays.asList(5, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ab Katy", Arrays.asList(0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Ab Lery", Arrays.asList(0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "Enriquez Chorizo", Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("1", "CIBER", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Aly", Arrays.asList(0, 10, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Nene", Arrays.asList(4, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Ab Alicia Esquina", Arrays.asList(3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Malcreado", Arrays.asList(2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Dozal", Arrays.asList(0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Gota Agua", Arrays.asList(6, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Micha ", Arrays.asList(5, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Nietos", Arrays.asList(6, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Valeria", Arrays.asList(5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Exp Norma", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Yubel", Arrays.asList(3, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Dominguez", Arrays.asList(10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Lujan", Arrays.asList(0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " La Queseria", Arrays.asList(5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " 3MARIAS", Arrays.asList(8, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Tinos Lizet", Arrays.asList(8, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " La Fama", Arrays.asList(0, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Nayar", Arrays.asList(3, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Carniceria Calle 7", Arrays.asList(0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Naranjito", Arrays.asList(0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Surtidor", Arrays.asList(0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Viridiana", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Exp Monica", Arrays.asList(3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " 3 en 1 (chuy)", Arrays.asList(4, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Pasadita", Arrays.asList(5, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Ginos", Arrays.asList(5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " ComoSuper", Arrays.asList(0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Av Juan Av 21", Arrays.asList(0, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Ab La Frontera", Arrays.asList(5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Super K", Arrays.asList(3, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Moderna", Arrays.asList(5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Ab Tanichi", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Ab Luz", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " La Mejor", Arrays.asList(0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Zuares", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Dayana", Arrays.asList(3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Av 2", Arrays.asList(3, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Chacon", Arrays.asList(3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Isela", Arrays.asList(3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Adrian Carniceria", Arrays.asList(10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Kinder", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Ely", Arrays.asList(4, 7, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Lazaro (Joselin)", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Wichos", Arrays.asList(5, 6, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Son Ver", Arrays.asList(6, 10, 6, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Miranda", Arrays.asList(0, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Piocha", Arrays.asList(5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " 2 Caritas", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Bere", Arrays.asList(6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Montaña", Arrays.asList(12, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Panchitos", Arrays.asList(5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Erika", Arrays.asList(5, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Jalisco", Arrays.asList(3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Torti Rosario", Arrays.asList(0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Tinos Velcro", Arrays.asList(8, 15, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Pasadita (Lety)", Arrays.asList(0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Pan Reyna", Arrays.asList(0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Castillo", Arrays.asList(3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Doña Bertha", Arrays.asList(0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Elenita", Arrays.asList(10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Ivan", Arrays.asList(0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Pueblo Nuevo", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Marquez", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Luz Av 18", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Arely", Arrays.asList(0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Mi Rancho El Tuty ", Arrays.asList(2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Azadero", Arrays.asList(15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Doña Mina", Arrays.asList(4, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Exp La 34", Arrays.asList(4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Vueltecita", Arrays.asList(6, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Figueroa", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Reynita", Arrays.asList(10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Enriquez", Arrays.asList(4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Adrian (Esquinita)", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " 3 Camelias", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Laborin", Arrays.asList(3, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("2", " Chihuas", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Omar", Arrays.asList(4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Sussan", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Brother Osmar", Arrays.asList(10, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " El SAUCE Placita", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " 2 Hermanos", Arrays.asList(12, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Gema", Arrays.asList(2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Esquinita", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Charly", Arrays.asList(5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " M@M", Arrays.asList(5, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Liz", Arrays.asList(3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Zusset", Arrays.asList(0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Nidia", Arrays.asList(5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Regina", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Angelica", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Paisa", Arrays.asList(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Karla", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Julissa", Arrays.asList(0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Doña Callejon", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Mini Lulu", Arrays.asList(0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Colmena", Arrays.asList(8, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Lulu Roman", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Papichulo", Arrays.asList(0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Toñita", Arrays.asList(0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Adrian Info", Arrays.asList(5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Amistad", Arrays.asList(2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Mendez Papeleria", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " La Negrita", Arrays.asList(3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Zaino", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Rosa", Arrays.asList(3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Angeles", Arrays.asList(0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Ximena", Arrays.asList(0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Cachis", Arrays.asList(15, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Super Gaby", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Super 33", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Guerigo", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Valo", Arrays.asList(5, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Six Lupita", Arrays.asList(5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Ab Lily", Arrays.asList(0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Yuly", Arrays.asList(2, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Tato", Arrays.asList(3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Luz Av 29", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Neto", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Adrian Cofiasa", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Expendio Progreso", Arrays.asList(0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Guadalupana", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Super Express", Arrays.asList(0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Paquime", Arrays.asList(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Franco", Arrays.asList(5, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Abatinos", Arrays.asList(4, 8, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Berenice", Arrays.asList(3, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Brissa", Arrays.asList(0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Wendy", Arrays.asList(0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " El Sauz", Arrays.asList(0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Karina", Arrays.asList(0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Yamileth", Arrays.asList(0, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Exp Luis", Arrays.asList(0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Daniel", Arrays.asList(0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Javier", Arrays.asList(0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Medina", Arrays.asList(0, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Milpa", Arrays.asList(0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Isma", Arrays.asList(0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Parra", Arrays.asList(0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0)));
        clients.add(new Clients("3", " Carniceria Vicky", Arrays.asList(0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0)));

        writeInfo();

    }

    private void writeInfo() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        for (int i = 0; i < clients.size(); i++) {
            db.collection("clients")
                    .add(clients.get(i))
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("TAG", "Info saved");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //Log.w(TAG, "Error adding document", e);
                        }
                    });
        }


    }


}

