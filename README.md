# blog-springboot-batch
blog-springbootで作ったサイトをGKEに置いてみたものの、データを入れる方法の一つとして作成。

GUIで作れるものをblog-posterとして作ってみたものの、時間もかかりそうなので、
持っているデータをDBに入れるものを作ります。

## 覚え書
blogのcontentsを今はsubmodule化しているので、
blog-contentsのリポジトリを更新した場合には、更新する必要がある。
このドキュメントを参照して、何もない状態からsubmoduleを取得する。

[自分が必要とする最低限の git submodule の知識](https://qiita.com/ma2saka/items/4bd00ef6f8c240847807)

以下のコマンドを実行

    git submodule update --init --recursive


既に、submoduleを読み込んだ後に更新する時は、
このドキュメントを参照する。

[git submoduleしてるリポジトリをリモートの最新に更新する](https://qiita.com/kshimo69/items/ac22d414d756ea08943f)

以下のコマンドを実行

    git submodule foreach git pull origin master

## 検討中のポイント
- entityを共通化するかは要検討
- ワンタイムで使うものなので、Docker化してKubernetesのCronJob等で使うのが良いかも