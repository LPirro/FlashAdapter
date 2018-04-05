# FlashAdapter
Flash Adapter allows you to create RecyclerViews Adapters quickly and easily, significantly reducing the boilerplate code

# Setup

#### 1. Add the JitPack repository to your root build.gradle file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

#### 2. Add the dependency to your app build.gradle file

	dependencies {
	        implementation 'com.github.LPirro:FlashAdapter:v0.0.1'
	}

# Usage
#### 1. Create the ViewHolder class

```
class UserViewHolder(itemView: View, listener: OnRecyclerItemClickListener?) : BaseViewHolder<User, OnRecyclerItemClickListener>(itemView, listener) {

    private var tvUserName: TextView? = null

    init {
        tvUserName = itemView.findViewById(R.id.tvUserName)

        listener?.let {
            itemView.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    override fun onBind(item: User) {
        tvUserName?.text = item.name
    }
}
```

#### 2. Create the adapter

```
class FlashSampleAdapter(context: Context, listener: OnRecyclerItemClickListener) :
        FlashAdapter<User, OnRecyclerItemClickListener, UserViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(inflate(R.layout.view_user, parent), getListener())
    }
}
```


### and you're done!

