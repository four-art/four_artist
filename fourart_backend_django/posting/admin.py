from django.contrib import admin
from posting.models import Post

@admin.register(Post)
class PostAdmin(admin.ModelAdmin):
    list_display = ('board_name','id','title','modify_dt')
    list_filter = ('modify_dt')
    search_fields = ('title','content')
    prepopulated_fields = {'slug' : ('title',)}