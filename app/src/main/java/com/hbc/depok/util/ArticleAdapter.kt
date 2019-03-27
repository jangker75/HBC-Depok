package com.hbc.depok.util

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.hbc.depok.R
import com.hbc.depok.model.ArticleModel
import com.hbc.depok.ui.DetailArtikelActivity
import java.util.ArrayList

class ArticleAdapter : RecyclerView.Adapter<DataViewHolderArticle>(),Filterable {
    private var articleSearchList:MutableList<ArticleModel> = mutableListOf()
    private val dataArticle: MutableList<ArticleModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolderArticle {
        return DataViewHolderArticle(LayoutInflater.from(parent.context).inflate(R.layout.item_data_article, parent, false))

    }
init {
   articleSearchList = dataArticle
}
    override fun getItemCount(): Int {
        return articleSearchList!!.size
    }
    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                   articleSearchList=dataArticle
                } else {
                    var filteredList = arrayListOf<ArticleModel>()
                    for (row in dataArticle) {

                        if (row.title!!.toLowerCase().contains(charString.toLowerCase()))  {
                            filteredList.add(row)
                        }
                    }

                    articleSearchList = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = articleSearchList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                articleSearchList = filterResults.values as ArrayList<ArticleModel>
                notifyDataSetChanged()
            }
        }
    }
    override fun onBindViewHolder(holder: DataViewHolderArticle, position: Int) {
        val article = articleSearchList!![position]
        holder.txtJudulArticle.text = article.title
        holder.txtCreatedAtArticle.text = article.created_at

        GlideApp.with(holder.itemView.context)
                .load(article.image)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageTumbArticle)
//        val txtID: TextView = holder.itemView.findViewById(R.id.txtID)
//        val txtNama: TextView = holder.itemView.findViewById(R.id.txtNama)
//        val txtPlat: TextView = holder.itemView.findViewById(R.id.txtPlat)
//        val imageTumb: ImageView = holder?.itemView.findViewById(R.id.imgView)
        holder?.article = articleSearchList[position]

//        fun bindModel(data: Data) {
//            txtID.text = data.kode_anggota
//            txtNama.text = data.Nama
//            txtPlat.text = data.No_plat
//
//            //  val options: RequestOptions = RequestOptions().error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher)
//            GlideApp.with(holder.itemView.context)
//                    .load(data.foto1)
//                    .placeholder(R.mipmap.ic_launcher)
//                    .into(imageTumb)
//            // Glide.with(holder?.itemView?.context).load(data.foto1).apply(options).into(imageTumb)
//            //  Picasso.get(holder?.itemView.context).load(data.foto1).into(imageTumb)
//        }
//        bindModel(data[position])


    }

    fun setData(datas: List<ArticleModel>) {
        dataArticle.addAll(datas)
        notifyDataSetChanged()
    }


}

class DataViewHolderArticle(itemView: View, var article: ArticleModel? = null) : RecyclerView.ViewHolder(itemView) {
    var txtJudulArticle: TextView
    var txtCreatedAtArticle: TextView
    var imageTumbArticle:ImageView
    companion object {
        val ARTICLE_TITLEARTICLE_KEY = "JUDULARTICLE"
        val ARTICLE_CONTENT_KEY = "CONTENTARTICLE"
        val ARTICLE_TANGGALARTICLE_KEY = "TANGGALTERBIT"
        val ARTICLE_FOTOARTICLE_KEY = "FOTOARTICLE"


    }

    init {
        imageTumbArticle = itemView.findViewById(R.id.imgViewArticle)
        txtJudulArticle = itemView.findViewById(R.id.txtJudulArticle)
        txtCreatedAtArticle = itemView.findViewById(R.id.txtTanggal)
        itemView.setOnClickListener {
        val intent = Intent(itemView.context, DetailArtikelActivity::class.java)

            intent.putExtra(ARTICLE_CONTENT_KEY, article?.content)
            intent.putExtra(ARTICLE_FOTOARTICLE_KEY, article?.image)
            intent.putExtra(ARTICLE_TANGGALARTICLE_KEY, article?.created_at)
            intent.putExtra(ARTICLE_TITLEARTICLE_KEY, article?.title)


            itemView.context.startActivity(intent)
        }
    }
}

