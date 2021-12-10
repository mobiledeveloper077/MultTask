package uz.abduvali.multtask.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso
import uz.abduvali.domain.entities.CharacterEntity
import uz.abduvali.domain.models.Result

fun Result.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id,
        image,
        location.name,
        name,
        status
    )
}

fun ImageView.setImage(url: String) {
    Picasso.get().load(url).into(this)
}