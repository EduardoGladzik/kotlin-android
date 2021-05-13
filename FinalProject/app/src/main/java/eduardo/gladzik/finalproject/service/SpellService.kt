package eduardo.gladzik.finalproject.service

import eduardo.gladzik.finalproject.model.Spell
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface SpellService {

    @GET("spells")
    fun findAll() : Call<List<Spell>>

    @POST("spells")
    fun save(@Body spell: Spell) : Call<Spell>

    @PUT("spells/{id}")
    fun update(@Path("id") id: Int, @Body spell: Spell) : Call<Spell>

    @DELETE("spells/{id}")
    fun delete(@Path("id") id: Int) : Call<ResponseBody>
}