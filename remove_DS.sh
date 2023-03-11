git rm --cached .DS_Store
find . -name .DS_Store -print0 | xargs -0 git rm --ignore-unmatch
echo .DS_Store >> ~/.gitignore_global
git config --global core.excludesfile ~/.gitignore_global
