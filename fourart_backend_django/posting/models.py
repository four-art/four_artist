from django.db import models
from django.urls import reverse_lazy
from django.contrib.auth.models import User
from django.utils.text import slugify

class Post(models.Model):
    title = models.CharField(verbose_name= 'TITLE',max_length= 50)
    slug = models.SlugField('SLUG',unique=True,allow_unicode=True,help_text= 'one word for title alias.')
    content = models.TextField('CONTENT')
    create_dt = models.DateTimeField('CREATE DATE',auto_now_add = True)
    modify_dt = models.DateTimeField('MODIFY DATE',auto_now=True)
    owner = models.ForeignKey(User,on_delete=models.CASCADE,verbose_name='OWNER',blank=True,null=True)
    board_name = models.CharField(verbose_name= 'BOARD NAME')

    class Meta:
        verbose_name = 'post'
        verbose_name_plural = 'posts'
        db_table = 'postings'
        ordering = ('-modify_dt',)#정렬순서

    def __str__(self):
        return self.title

    def get_absolute_url(self):
        return reverse_lazy('posting:post_detail', args=(self.slug,))

    def get_previous(self):
        return self.get_previous_by_modify_dt()

    def get_next(self):
        return self.get_next_by_modify_dt()

    def save(self, *args, **kwargs):
        self.slug = slugify(self.title, allow_unicode=True)
        super().save(*args, **kwargs)
