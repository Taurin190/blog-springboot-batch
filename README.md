# blog-springboot-batch
blog-springbootで作ったサイトをGKEに置いてみたものの、データを入れる方法の一つとして作成。

GUIで作れるものをblog-posterとして作ってみたものの、時間もかかりそうなので、
持っているデータをDBに入れるものを作ります。

## 覚え書
blogのcontentsを今はsubmodule化しているので、
blog-contentsのリポジトリを更新した場合には、更新する必要がある。

このドキュメントを参照して、
[git submoduleしてるリポジトリをリモートの最新に更新する](https://qiita.com/kshimo69/items/ac22d414d756ea08943f)

以下のコマンドを実行

    git submodule foreach git pull origin master

## 検討中のポイント
- entityを共通化するかは要検討
- ワンタイムで使うものなので、Docker化してKubernetesのCronJob等で使うのが良いかも